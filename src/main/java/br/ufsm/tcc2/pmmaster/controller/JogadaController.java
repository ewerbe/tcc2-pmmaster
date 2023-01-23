package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Carta;
import br.ufsm.tcc2.pmmaster.model.Jogada;
import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import br.ufsm.tcc2.pmmaster.service.JogadaService;
import br.ufsm.tcc2.pmmaster.service.TabuleiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class JogadaController {

    @Autowired
    JogadaService jogadaService;
    @Autowired
    TabuleiroService tabuleiroService;

    //o jogador entrou a partir do qrcode do tabuleiro;
    @RequestMapping(value = "/jogada-areas-conhecimento.action", method = RequestMethod.GET)
    public String getJogadaAreasConhecimento(Model model, HttpServletRequest request,
                                             @RequestParam(value = "VwqpHstBcVtUNnnG")Long idTabuleiro) {
        Long idCartaAtiva = null;
        Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
        //ativa o tabuleiro;
        if(!tabuleiro.getAtivo()) {
            tabuleiro.setAtivo(true);
        }
        //traz as jogadas do tabuleiro, para pegar a que tá ativa, se houver alguma.
        List<Jogada> jogadasTabuleiro = jogadaService.
                findJogadaByTabuleiro(tabuleiroService.find(idTabuleiro));
        Jogada jogadaAtual = null;

        for(Jogada jogada : jogadasTabuleiro) {
            if(jogada.getAtiva()) {
                jogadaAtual = jogada;
            }
        }
        //já tem jogada aberta no tabuleiro, entra direto na carta aberta. sem direito à resposta;
        if(jogadaAtual != null && jogadaAtual.getAtiva()) {
            boolean fechar = true;
            return "redirect:/cartas/carta.action?id="+jogadaAtual.getIdCarta().getId()+
                    "&fechar=true&idTabuleiro="+idTabuleiro;
        } else {
            // jogadaAbertaAtual = abreJogada(idTabuleiro);
            //var para receber o idAreaConhecimento pela seleção do user;
            //model.addAttribute("idAreaConhecimentoCarta", null);
            //model.addAttribute("jogadaAbertaAtual", jogadaAbertaAtual);
            model.addAttribute("idTabuleiro", idTabuleiro);
            return "jogada-areas-conhecimento";
        }
    }

    //hash resposta = oPtujCRT

    @RequestMapping(value = "/jogadas/jogada.action", method = RequestMethod.GET)
    public String getResultadoResposta(Model model,
                                       @RequestParam(value = "id")Long idJogadaAtual,
                                       @RequestParam(value = "oPtujCRT")int respostaDada){
        Boolean resultado = getResultadoJogada(idJogadaAtual, respostaDada);
        Jogada jogadaAtual = jogadaService.find(idJogadaAtual);
        jogadaAtual.setAtiva(false);
        jogadaService.save(jogadaAtual);
        model.addAttribute("jogadaAtual", jogadaAtual);
        model.addAttribute("resultado", resultado);
        return "feedback";
    }

    @RequestMapping(value = "/jogadas/fechar-jogada.action", method = RequestMethod.GET)
    public String fechaJogadaAtualParaTabuleiro(Model model,
                                       @RequestParam(value = "id")Long idJogadaAtual){
        Jogada jogadaAtual = jogadaService.find(idJogadaAtual);
        jogadaAtual.setAtiva(false);
        jogadaAtual.setAntiga(false);
        jogadaService.save(jogadaAtual);
        return "redirect:/";
    }

    //método para FINALIZAR A PARTIDA;
    @RequestMapping(value = "/jogadas/finalizar-partida.action", method = RequestMethod.GET)
    public String finalizarPartidaParaTabuleiro(Model model,
//                                                @RequestParam(value = "id", required = false)
//                                                        Long idJogadaAtual,
                                                @RequestParam(value = "id", required = false)
                                                            Long idTabuleiro){
        Tabuleiro tabuleiro;
//        Jogada jogadaAtual;
//        if(idJogadaAtual!=null) {
//            jogadaAtual = jogadaService.find(idJogadaAtual);
//            tabuleiro = tabuleiroService.find(jogadaAtual.getTabuleiro().getId());
//        } else {
            tabuleiro = tabuleiroService.find(idTabuleiro);
       // }
        List<Jogada> jogadasTabuleiro = jogadaService.findJogadaByTabuleiro(tabuleiro);
        //passa todas as jogadas para a antiguidade do tabuleiro;
        //para não influenciar na cartas abertas na partida atual do tabuleiro.
        for(Jogada jogada : jogadasTabuleiro) {
            jogada.setAntiga(true);
            jogada.setAtiva(false);
            jogadaService.save(jogada);
        }
        //desativando o tabuleiro para finalizar a partida atual.
        tabuleiro.setAtivo(false);
        tabuleiroService.save(tabuleiro);
        //jogadaService.save(jogadaAtual);
        return "redirect:/";
    }

    @RequestMapping(value = "/jogadas/reiniciar-partida.action", method = RequestMethod.GET)
    public String reiniciarPartidaParaTabuleiro(Model model,
//                                                @RequestParam(value = "id", required = false)
//                                                        Long idJogadaAtual,
                                                @RequestParam(value = "id", required = false)
                                                        Long idTabuleiro){
        Tabuleiro tabuleiro;

        tabuleiro = tabuleiroService.find(idTabuleiro);
        // }
        List<Jogada> jogadasTabuleiro = jogadaService.findJogadaByTabuleiro(tabuleiro);
        //passa todas as jogadas para a antiguidade do tabuleiro;
        //para não influenciar na cartas abertas na partida atual do tabuleiro.
        for(Jogada jogada : jogadasTabuleiro) {
            jogada.setAntiga(true);
            jogada.setAtiva(false);
            jogadaService.save(jogada);
        }
        //desativando o tabuleiro para finalizar a partida atual.
        tabuleiro.setAtivo(false);
        tabuleiroService.save(tabuleiro);
        //jogadaService.save(jogadaAtual);
        return "redirect:/";
    }

    //////////////////////////////

    private boolean getResultadoJogada(Long idJogadaAtual, int respostaDada) {
        Carta cartaAtual = jogadaService.find(idJogadaAtual).getIdCarta();
        if(cartaAtual.getAltern_correta().equals("A")) {
            if(respostaDada == 1) {
                return true;
            } else {
                return false;
            }
        } else if(cartaAtual.getAltern_correta().equals("B")) {
            if(respostaDada == 2) {
                return true;
            } else {
                return false;
            }
        } else if(cartaAtual.getAltern_correta().equals("C")) {
            if(respostaDada==3) {
                return true;
            } else {
                return false;
            }
        } else if(cartaAtual.getAltern_correta().equals("D")) {
            if(respostaDada==4) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

//    private Jogada temJogadaAberta(Long idTabuleiro) {
//        Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
//        Jogada jogadaAberta = jogadaService.findJogadaByTabuleiro(tabuleiro);
//        if(jogadaAberta != null && jogadaAberta.getAtiva()) {
//            return true;
//        }
//        return false;
//    }

    private Jogada abreJogada(Long idTabuleiro) {
        Jogada jogadaAbertaAtual = new Jogada();
        jogadaAbertaAtual.setTabuleiro(tabuleiroService.find(idTabuleiro));
        jogadaAbertaAtual.setAtiva(true);

        return jogadaAbertaAtual;
    }

//    @RequestMapping(value = "/jogada-areas-conhecimento.action", method = RequestMethod.GET)
//    public String getJogada(Model model, HttpServletRequest request,
//                            @RequestParam(value = "idTabuleiro")Long idTabuleiro) {
//        Jogada jogadaAberta = jogadaService.findJogadaByTabuleiro(idTabuleiro);
//        if(jogadaAberta == null) {
//            return "jogada-areas-conhecimento";
//        } else {
//            return "redirect:/cartas/carta.action?id="+jogadaAberta.getIdCarta();
//        }
//    }
}
