package ma.enset.projet_spring1.Repository;

import ma.enset.projet_spring1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNom(String nom);
}
