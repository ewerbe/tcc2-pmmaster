package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.AreaConhecimento;
import br.ufsm.tcc2.pmmaster.model.Carta;
import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.AreaConhecimentoService;
import br.ufsm.tcc2.pmmaster.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartaController {

    @Autowired
    CartaService cartaService;
    @Autowired
    AreaConhecimentoService areaConhecimentoService;

    @RequestMapping(value = "/cadastro-carta.action", method = RequestMethod.POST)
    public String getCadastroCarta(Model model,
                                   @RequestParam(value = "idAreaConhecimentoCarta", required = false)
                                           Long idAreaConhecimentoCarta) {

//                                         @RequestParam(value = "idUsuario")Long idUsuario) {
        ArrayList<Character> alternativas = getAlternativas();
//        Usuario usuario = usuarioService.find(idUsuario);

        // model.addAttribute("usuario", usuario);
        model.addAttribute("idAreaConhecimentoCarta", idAreaConhecimentoCarta);
        model.addAttribute("alternativas", alternativas);

        return "cadastro-carta";
    }

    @RequestMapping(value = "/cartas.action", method = RequestMethod.GET)
    public String getCartas(Model model) {
//                                   @RequestParam(value = "idUsu", required = false)Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        List<Carta> cartas;
        cartas = cartaService.findAll();

        model.addAttribute("cartas", cartas);
        //model.addAttribute("usuario", usuario);

        return "cartas";
    }

    @RequestMapping(value = "/cartas/carta.action", method = RequestMethod.GET)
    public String verCarta(Model model, HttpServletRequest request,
                                    @RequestParam(value = "id") Long idCarta) {
//                                    @RequestParam(value = "idUsu")Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        Carta carta = cartaService.find(idCarta);

        //model.addAttribute("usuario", usuario);
        model.addAttribute("idAreaConhecimentoCarta", carta.getAreaConhecimento().getId());
        model.addAttribute("carta", carta);

        return "carta";
    }

    @RequestMapping(value = "/carta/salvar-carta.action", method = RequestMethod.POST)
    public String salvarCarta(HttpServletRequest request,
                              @RequestParam(value = "idAreaConhecimentoCarta", required = false)
                                      Long idAreaConhecimentoCarta){
//                                    @RequestParam(value = "idUsu", required = false)Long idUsu) {

        String idCartaString = request.getParameter("idCarta");
        Long idCarta = null;
        if(idCartaString != null) {
            idCarta = Long.valueOf(idCartaString);
        }
        String pergunta = request.getParameter("perguntaCarta");
        //Long idAreaConhecCarta = Long.valueOf(request.getParameter("idAreaConhecCarta"));
        //Long idAreaConhecCarta = 1L;
        String altern_A = request.getParameter("altern_A");
        String altern_B = request.getParameter("altern_B");
        String altern_C = request.getParameter("altern_C");
        String altern_D  = request.getParameter("altern_D");
        String altern_correta = request.getParameter("altern_correta");
        String ativaString = request.getParameter("checkCartaAtiva");
        Boolean ativa = ativaString != null && ativaString.equals("on");
        AreaConhecimento areaConhecimento;
        Carta cartaNova = new Carta();
        cartaNova.setId(idCarta);

            if(idAreaConhecimentoCarta == null) {
                areaConhecimento = (cartaService
                        .find(Long.valueOf(request.getParameter("idCarta")))).getAreaConhecimento();
                cartaNova.setAreaConhecimento(areaConhecimento);
            } else {
                areaConhecimento = areaConhecimentoService.find(idAreaConhecimentoCarta);
                cartaNova.setAreaConhecimento(areaConhecimento);
            }
//            if (areaConhecimento != null) {
//                cartaNova.setAreaConhecimento(areaConhecimento);
//            } else {
//                cartaNova.setAreaConhecimento(null);
//            }
        cartaNova.setPergunta(pergunta);
        cartaNova.setAltern_A(altern_A);
        cartaNova.setAltern_B(altern_B);
        cartaNova.setAltern_C(altern_C);
        cartaNova.setAltern_D(altern_D);
        cartaNova.setAltern_correta(altern_correta);
        cartaNova.setAtiva(ativa);

       cartaService.save(cartaNova);
       //model.addAttribute("idAreaConhecimentoCarta", cartaNova.getAreaConhecimento().getId());

        return "redirect:/areas-conhecimento/cartas-area-conhecimento.action?id="+cartaNova.getAreaConhecimento().getId();
    }

    @RequestMapping(value = "/carta/editar-carta.action", method = RequestMethod.POST)
    public String editarCarta(Model model, HttpServletRequest request,
                                    @RequestParam(value = "id") Long idCarta) {
//                                    @RequestParam(value = "idUsu")Long idUsu) {

        //Usuario usuario = usuarioService.find(idUsu);
        Carta cartaEditar = cartaService.find(idCarta);

        //model.addAttribute("usuario", usuario);
        model.addAttribute("alternativas", getAlternativas());
        model.addAttribute("cartaEditar", cartaEditar);
        model.addAttribute("idAreaConhecimentoCarta", cartaEditar.getAreaConhecimento().getId());

        return "cadastro-carta";
    }

    @RequestMapping(value = "/carta/excluir-carta.action", method = RequestMethod.POST)
    public String excluirCarta(HttpServletRequest request, Model model) {
//                                     @RequestParam(value = "idUsu")Long idUsu) {

        Long idCarta = Long.parseLong(request.getParameter("idCarta"));
        Carta cartaExcluir = cartaService.find(idCarta);
        Long idAreaConhecimentoCarta = cartaExcluir.getAreaConhecimento().getId();
        cartaService.delete(cartaExcluir);

        model.addAttribute("idAreaConhecimentoCarta", idAreaConhecimentoCarta);
//        return "redirect:/usuarios.action?idUsu="+idUsu;
        return "redirect:/cartas.action";
    }

    ///////////////////////////

    private ArrayList<Character> getAlternativas(){
        ArrayList<Character> alternativas = new ArrayList<>();
        alternativas.add('A');
        alternativas.add('B');
        alternativas.add('C');
        alternativas.add('D');

        return alternativas;
    }

    private List<AreaConhecimento> getAreasConhecimento() {
        return areaConhecimentoService.findAll();
    }
}
