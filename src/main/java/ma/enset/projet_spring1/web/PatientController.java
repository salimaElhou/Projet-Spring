package ma.enset.projet_spring1.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.projet_spring1.Repository.PatientRepository;
import ma.enset.projet_spring1.entities.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name= "page",defaultValue = "0") int page,//recupere le param page et effecter a page
                        @RequestParam(name= "size",defaultValue = "4") int size,
                        @RequestParam(name= "keyword",defaultValue = "") String kw){
        Page<Patient> pagePatients=patientRepository.findByNomContains(kw,PageRequest.of(page,size)); //size = nbr de lignes

       model.addAttribute("ListPatients",pagePatients.getContent());
       model.addAttribute("pages",new int[pagePatients.getTotalPages()]);//tableau = nbr total de page pour faire la majination
        model.addAttribute("currentpage",page);
        model.addAttribute("keyword",kw);
    return "patients";//retourner la vue
    }


@GetMapping("/delete")
    public String delete(Long id,String keyword , int page){
        patientRepository.deleteById(id);
        //on supprime et en revenir a la page index
    return "redirect:/index?page="+page+"&keyword="+keyword;

    }


}
