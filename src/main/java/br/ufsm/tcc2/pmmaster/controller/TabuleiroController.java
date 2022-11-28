package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import br.ufsm.tcc2.pmmaster.service.TabuleiroService;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TabuleiroController {

    @Autowired
    private TabuleiroService tabuleiroService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/tabuleiros.action", method = RequestMethod.GET)
    public String getTabuleiros(Model model) {
//                                   @RequestParam(value = "idUsu", required = false)Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        List<Tabuleiro> tabuleiros;
        tabuleiros = tabuleiroService.findAll();

        model.addAttribute("tabuleiros", tabuleiros);
        //model.addAttribute("usuario", usuario);

        return "tabuleiros";
    }

    @RequestMapping(value = "/tabuleiros/novo-tabuleiro.action", method = RequestMethod.POST)
    public String salvarCarta(Model model, HttpServletRequest request,
                              @RequestParam(value = "idUsuario", required = false)Long idUsuario){

        //TODO: teste com ID_TABULEIRO fixo, para por o tabueleiro Jasper na webapp;
        Long idTabuleiro = 1L;

        Tabuleiro tabuleiroNovo = new Tabuleiro();
        tabuleiroNovo.setId(idTabuleiro);
        tabuleiroNovo.setIdUsuario(usuarioService.find(idUsuario));

        //consistir o novo tabuleiro no banco;
        tabuleiroService.save(tabuleiroNovo);
        //criar o novo arquivo (jasper) do tabuleiro, passando o idUsuario pra gerar a URL destino do QRCODE;
        Boolean tabuleiroGerado = geraArquivoTabuleiro(tabuleiroNovo.getIdUsuario().getId());

        return "redirect:/tabuleiros.action";
    }

    ////////////////////////////

    private Boolean geraArquivoTabuleiro(Long idUsuario) {
        //chamar métodos Jasper de criação do tabuleiro.pdf;
        return true;
    }
}
