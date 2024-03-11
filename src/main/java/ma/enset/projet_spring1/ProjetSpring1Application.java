package ma.enset.projet_spring1;

import jakarta.servlet.ServletOutputStream;
import ma.enset.projet_spring1.Repository.PatientRepository;
import ma.enset.projet_spring1.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class ProjetSpring1Application implements CommandLineRunner {
    @Autowired // Annotation pour injecter PatientRepository

    private  PatientRepository patientRepository; // Injection de dépendance



    public static void main(String[] args) {
        SpringApplication.run(ProjetSpring1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // - Ajouter des patients
        patientRepository.save(new Patient(null,"salima",new Date(),false,0));
        patientRepository.save(new Patient(null,"salma",new Date(),false,2));
        patientRepository.save(new Patient(null,"imane",new Date(),false,6));
        // - Consulter tous les patients
        List<Patient> Patients = patientRepository.findAll();
        System.out.println("la list des patients : ");
        Patients.forEach(patient ->{
            System.out.println(patient.toString());
        });
        // - Consulter un patient
        //Afficher les informations par ID
        Patient patient= patientRepository.findById(Long.valueOf(1)).orElse(null);
        if(patient !=null){
            System.out.println("*****************");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissane());
            System.out.println(patient.getMalade());
            System.out.println(patient.getScore());
            System.out.println("*****************");
        }else{
            System.out.println("Patient non trouvé !");
        }

        //- Chercher des patients
            System.out.println("Entrez le nom du patient à chercher :");
            Scanner scanner = new Scanner(System.in);
            String nomRecherche= scanner.next();
            List<Patient> patientsTrouves = patientRepository.findByNom(nomRecherche); // Remplacez 'nomRecherche' par le nom que vous recherchez
        System.out.println("la list des patients par Nom : ");
        patientsTrouves.forEach(p ->{
            System.out.println(p.toString());
        });
        //- Chercher des patients avec Search
        // ou bien findByPriceGreaterThan(3000) le cas de produit
        System.out.println("---------------");
        List<Patient> patientsSearch = patientRepository.Search("%S%"); // Remplacez 'nomRecherche' par le nom que vous recherchez
        System.out.println("la list des patients par Nom (Search) : ");
        patientsSearch.forEach(p ->{
            System.out.println(p.toString());
        });



        // - Mettre à jour un patient
        Patient patient1= patientRepository.findById(Long.valueOf(1)).orElse(null);
        if (patient1!=null) {
            // Mettez à jour les propriétés du patient selon vos besoins
            patient1.setNom("nouveauNom");
            patient1.setDateNaissane(new Date());
            patient1.setMalade(true);
            patient1.setScore(2);
            patientRepository.save(patient);
            System.out.println("Patient mis à jour avec succès !");

        } else {
            // Gérer le cas où le patient n'est pas trouvé
            System.out.println("Patient non trouvé !");
        }


        //- supprimer un patient
        System.out.println("Entrez l'ID du patient à supprimer : ");
        Long idPatient = scanner.nextLong();
        if(patientRepository.existsById(idPatient)) {
            patientRepository.deleteById(idPatient);
            System.out.println("Patient supprimé avec succès !");
        } else {
            System.out.println("Patient non trouvé !");
        }



    }
}
