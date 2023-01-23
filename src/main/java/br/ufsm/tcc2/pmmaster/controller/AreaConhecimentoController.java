package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.AreaConhecimento;
import br.ufsm.tcc2.pmmaster.model.Carta;
import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.AreaConhecimentoService;
import br.ufsm.tcc2.pmmaster.service.CartaService;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AreaConhecimentoController {

    @Autowired
    AreaConhecimentoService areaConhecimentoService;
    @Autowired
    CartaService cartaService;
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/areas-conhecimento.action", method = RequestMethod.GET)
    public String getAreasConhecimento(Model model,
                                       @RequestParam(value = "idUsu", required = false)Long idUsu) {

        Usuario usuario;
        if(idUsu!=null) {
            usuario = usuarioService.find(idUsu);
            model.addAttribute("usuario", usuario);
        }

        List<AreaConhecimento> areasConhecimento;
        areasConhecimento = areaConhecimentoService.findAll();
        model.addAttribute("areasConhecimento", areasConhecimento);
        return "areas-conhecimento";
    }

    @RequestMapping(value = "/areas-conhecimento/cartas-area-conhecimento.action", method = RequestMethod.GET)
    public String getCartasAreaConhecimento(Model model, @RequestParam(value = "id")Long idAreaConhecimento){
        List<Carta> cartas = cartaService.findByAreaConhecimento(idAreaConhecimento);

        model.addAttribute("idAreaConhecimentoCarta", idAreaConhecimento);
        model.addAttribute("cartas", cartas);
        return "cartas";
    }
}
