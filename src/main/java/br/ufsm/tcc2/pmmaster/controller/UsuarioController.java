package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login/logar.action", method = RequestMethod.POST)
    public String getUserAdmin(HttpServletRequest request, Model model) {
        Usuario usuario = usuarioService.findByNome(request.getParameter("login"));
        if(usuario!=null) {
            if(usuario.getSenha().equals(request.getParameter("senha"))) {
                return "redirect:/areas-conhecimento.action?idUsu="+usuario.getId();
            } else {
                return "login";
            }
        }
        return "login";
    }



}

