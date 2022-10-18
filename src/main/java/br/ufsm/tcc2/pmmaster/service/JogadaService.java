package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.Jogada;
import br.ufsm.tcc2.pmmaster.repository.JogadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadaService {

    @Autowired
    JogadaRepository jogadaRepository;

    public Jogada find(Long idJogada) {
        return jogadaRepository.findById(idJogada).orElse(null);
    }

    public void save(Jogada jogada) {
        jogadaRepository.save(jogada);
    }

    public List<Jogada> findAll() {
        return jogadaRepository.findAll();
    }

    public void delete(Jogada jogada) {
        jogadaRepository.delete(jogada);
    }
}
