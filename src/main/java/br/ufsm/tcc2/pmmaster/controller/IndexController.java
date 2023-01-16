package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/", "/home"})
    public String getIndex(Model model) {
        //List<Usuario> usuarios = usuarioService.findAll();
        //Usuario usuario = usuarios.get(0);
        model.addAttribute("idUsuario", 1L);
        return "home";
    }


}
