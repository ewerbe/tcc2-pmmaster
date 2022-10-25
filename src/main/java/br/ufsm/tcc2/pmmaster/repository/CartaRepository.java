package br.ufsm.tcc2.pmmaster.repository;

import br.ufsm.tcc2.pmmaster.model.AreaConhecimento;
import br.ufsm.tcc2.pmmaster.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaRepository extends JpaRepository <Carta, Long> {

    List<Carta> findByAreaConhecimento(AreaConhecimento areaConhecimento);
}
