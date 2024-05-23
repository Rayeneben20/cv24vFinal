package fr.univrouen.cv24v1.Controllers;

import fr.univrouen.cv24v1.Services.Cv24Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private Cv24Service cv24Service;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "accueil");
        return "index";
    }

    @GetMapping("/help")
    public String aide(Model model) {
        model.addAttribute("page", "aide");
        return "aide";
    }
}
