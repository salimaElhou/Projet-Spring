package ma.enset.projet_spring1.Repository;

import ma.enset.projet_spring1.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNom(String nom);
    @Query("select  p from Patient p where p.nom like :x") //utilise Hql
    List<Patient> Search(@Param("x") String mc);

    Page<Patient> findByNomContains(String keyword, Pageable pageable); //pageable pour faire la majination
}
