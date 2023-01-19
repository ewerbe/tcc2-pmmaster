package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.*;
import br.ufsm.tcc2.pmmaster.service.AreaConhecimentoService;
import br.ufsm.tcc2.pmmaster.service.CartaService;
import br.ufsm.tcc2.pmmaster.service.JogadaService;
import br.ufsm.tcc2.pmmaster.service.TabuleiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class CartaController {

    @Autowired
    CartaService cartaService;
    @Autowired
    AreaConhecimentoService areaConhecimentoService;
    @Autowired
    JogadaService jogadaService;
    @Autowired
    TabuleiroService tabuleiroService;

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
                                    @RequestParam(value = "id") Long idCarta,
                                    @RequestParam(value = "fechar", required=false)
                                       boolean fecharAternativas) {
//                                    @RequestParam(value = "idUsu")Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        Carta carta = cartaService.find(idCarta);

        //model.addAttribute("usuario", usuario);
        model.addAttribute("fecharAternativas", fecharAternativas);
        model.addAttribute("idAreaConhecimentoCarta", carta.getAreaConhecimento().getId());
        model.addAttribute("carta", carta);
        return "carta";
    }

    //usuário vindo da seleção da área de conhecimento para gerar carta para a sua jogada;
    @RequestMapping(value = "/cartas/jogada.action", method = RequestMethod.GET)
    public String abrirCarta(Model model, HttpServletRequest request,
                           @RequestParam(value = "JklrFqaC") Long idAreaConhecimentoCarta,
                             @RequestParam(value = "kTbrnMSw")Long idTabuleiro) {
//                                    @RequestParam(value = "idUsu")Long idUsu) {
        //Usuario usuario = usuarioService.find(idUsu);
        //Carta carta = cartaService.find(idCarta);
        Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
        Carta cartaAtual = getCartaParaJogadaAtual(idAreaConhecimentoCarta, idTabuleiro);
        if(cartaAtual.getPergunta().length() > 250) {
            model.addAttribute("diminuirFonte", true);
            System.out.println("******************************************************************** tamanho > 250");
        }
        Jogada jogadaAtual = new Jogada();

        if(tabuleiro != null) {
            //abre e ativa a jogada atual com a sua respectiva carta;
            jogadaAtual.setIdCarta(cartaAtual);
            jogadaAtual.setTabuleiro(tabuleiro);
            jogadaAtual.setAtiva(true);
            jogadaAtual.setAntiga(false);
            jogadaService.save(jogadaAtual);
        }
        //abre a tela com a carta aberta para ser respondida;
//JklrFqaC=1&&kTbrnMSw
        //model.addAttribute("usuario", usuario);
        model.addAttribute("fecharAlternativas", false);
        model.addAttribute("jogadaAtual", jogadaAtual);
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

    private Carta getCartaParaJogadaAtual(Long idAreaConhecimento, Long idTabuleiro) {
        //retorna a carta gerada para a jogada atual.
        Random random = new Random();
        List<Carta> cartasTotais = cartaService.findByAreaConhecimento(idAreaConhecimento);//getCartasAtivas(idAreaConhecimento, idTabuleiro);
        int limiteIndex = cartasTotais.size();
        Long indexCartaToShow;
        Carta cartaAtual = null;
        //vai gerar uma carta aleatoriamente dentro da determinada área de conhecimento.
        do{
            indexCartaToShow = Long.valueOf(random.nextInt(limiteIndex));
        } while(indexCartaToShow == 0 || indexCartaToShow == null ||
                seCartaInativa(indexCartaToShow, cartasTotais, idTabuleiro));

        cartaAtual = cartasTotais.get(Math.toIntExact(indexCartaToShow));
        return cartaAtual;
    }

    private boolean seCartaInativa(Long indexCartaToShow, List<Carta> cartasTotais,
                                   Long idTabuleiro) {
        //se a carta é inativa, retorna true;
        Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
        List<Jogada> jogadasTabuleiro = jogadaService.findJogadaByTabuleiro(tabuleiro);

        //se a carta já foi aberta em uma jogada atual, retorna "true", senão, "false";
        for(Jogada jogadaTabuleiro : jogadasTabuleiro) {
            if(!jogadaTabuleiro.getAntiga() && jogadaTabuleiro.
                    getIdCarta().getId() == cartasTotais.get(Math.toIntExact(indexCartaToShow)).getId()) {
                return true;
            }
        }
        return false;
    }

    private List<Carta> getCartasAtivas(Long idAreaConhecimento, Long idTabuleiro) {
//        int totalCartasAtivas = cartaService.getTotalCartasAtivasPorAreaConhecimento(idAreaConhecimento);
        List<Carta> cartasAreaConhecimento = cartaService.findByAreaConhecimento(idAreaConhecimento);
        List<Carta> cartasAtivas = new LinkedList<>();
        List<Carta> cartasInativas = new LinkedList<>();
        List<Jogada> jogadasTabuleiro = jogadaService.findJogadaByTabuleiro(tabuleiroService.find(idTabuleiro));
        int totalCartasAtivas = 0;

        for(Carta carta : cartasAtivas) {
            for(Jogada jogada : jogadasTabuleiro) {
                if ( (carta.getId() == jogada.getIdCarta().getId()) && !jogada.getAntiga() ){
                    cartasInativas.add(carta);
                }else {
                    cartasAtivas.add(carta);
                }
            }
        }
        //totalCartasAtivas = ( cartasAreaConhecimento.size() - cartasInativas.size() );
        return cartasAtivas;
    }

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
