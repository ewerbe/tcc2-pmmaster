package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/cadastro-usuario.action", method = RequestMethod.GET)
    public String getCadastroUsuario(Model model) {
//                                         @RequestParam(value = "idUsuario")Long idUsuario) {

//        Usuario usuario = usuarioService.find(idUsuario);

       // model.addAttribute("usuario", usuario);
        return "cadastro-usuario";
    }

    @RequestMapping(value = "/usuarios.action", method = RequestMethod.GET)
    public String getUsuarios(Model model) {
//                                   @RequestParam(value = "idUsu", required = false)Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        List<Usuario> usuarios;
        usuarios = usuarioService.findAll();

        model.addAttribute("usuarios", usuarios);
        //model.addAttribute("usuario", usuario);

        return "usuarios";
    }


//    @RequestMapping(value = "/usuario/salvar-usuario.action", method = RequestMethod.POST)
//    public String salvarColaborador(Model model, HttpServletRequest request) {
////                                    @RequestParam(value = "idUsu", required = false)Long idUsu) {
//
//        String idUsuarioString = request.getParameter("idUsuario");
//        Long idUsuario = null;
//        if(idUsuarioString != null) {
//            idUsuario = Long.valueOf(idUsuarioString);
//        }
//        String nome = request.getParameter("nomeUsuario");
//        String email = request.getParameter("emailUsuario");
//        String senha = request.getParameter("senhaUsuario");
//        String ativoString = request.getParameter("checkUsuarioAtivo");
//        Boolean ativo = ativoString != null && ativoString.equals("on");
//
//        Usuario usuarioNovo = new Usuario();
//        usuarioNovo.setId(idUsuario);
//        usuarioNovo.setNome(nome);
//        usuarioNovo.setEmail(email);
//        usuarioNovo.setSenha(senha);
//        usuarioNovo.setAtivo(ativo);
//
//        usuarioService.save(usuarioNovo);
//
//        return "redirect:/usuarios.action";
//    }

//    @RequestMapping(value = "/usuario/editar-usuario.action", method = RequestMethod.POST)
//    public String editarColaborador(Model model, HttpServletRequest request,
//                                    @RequestParam(value = "id") Long idUsuario) {
////                                    @RequestParam(value = "idUsu")Long idUsu) {
//
//        //Usuario usuario = usuarioService.find(idUsu);
//        Usuario usuarioEditar = usuarioService.find(idUsuario);
//
//        //model.addAttribute("usuario", usuario);
//        model.addAttribute("usuarioEditar", usuarioEditar);
//
//        return "cadastro-usuario";
//    }

//    @RequestMapping(value = "/usuario/excluir-usuario.action", method = RequestMethod.POST)
//    public String excluirColaborador(HttpServletRequest request) {
////                                     @RequestParam(value = "idUsu")Long idUsu) {
//
//        Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
//        Usuario usuarioExcluir = usuarioService.find(idUsuario);
//        usuarioService.delete(usuarioExcluir);
//
////        return "redirect:/usuarios.action?idUsu="+idUsu;
//        return "redirect:/usuarios.action";
//    }


}

