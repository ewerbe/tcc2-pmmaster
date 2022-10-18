package br.ufsm.tcc2.pmmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String getIndex(Model model) {
        //model.addAttribute("isGerente", true);
        return "home";
    }
}
