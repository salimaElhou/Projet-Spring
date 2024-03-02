package ma.enset.projet_spring1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    private Date dateNaissane;
    private  Boolean malade;
    private int score;



}
