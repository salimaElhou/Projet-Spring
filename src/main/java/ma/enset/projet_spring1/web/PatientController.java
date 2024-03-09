package ma.enset.projet_spring1.web;

import lombok.AllArgsConstructor;
import ma.enset.projet_spring1.Repository.PatientRepository;
import ma.enset.projet_spring1.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@AllArgsConstructor
public class PatientRController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
public String index(){
    return "patients";
}


}
