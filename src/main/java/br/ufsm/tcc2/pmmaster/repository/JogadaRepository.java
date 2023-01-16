package br.ufsm.tcc2.pmmaster.repository;

import br.ufsm.tcc2.pmmaster.model.Jogada;
import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadaRepository extends JpaRepository <Jogada, Long>{
    List<Jogada> findJogadaByTabuleiro(Tabuleiro tabuleiro);
}
