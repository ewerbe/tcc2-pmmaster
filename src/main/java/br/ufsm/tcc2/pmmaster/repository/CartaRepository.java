package br.ufsm.tcc2.pmmaster.repository;

import br.ufsm.tcc2.pmmaster.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository <Carta, Long> {
}
