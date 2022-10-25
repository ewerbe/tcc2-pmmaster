package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.AreaConhecimento;
import br.ufsm.tcc2.pmmaster.service.AreaConhecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AreaConhecimentoController {

    @Autowired
    AreaConhecimentoService areaConhecimentoService;

    @RequestMapping(value = "/areas-conhecimento.action", method = RequestMethod.GET)
    public String getAreasConhecimento(Model model) {
//                                   @RequestParam(value = "idUsu", required = false)Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        List<AreaConhecimento> areasConhecimento;
        areasConhecimento = areaConhecimentoService.findAll();

        model.addAttribute("areasConhecimento", areasConhecimento);
        //model.addAttribute("usuario", usuario);

        return "areas-conhecimento";
    }
}
