package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import br.ufsm.tcc2.pmmaster.repository.TabuleiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabuleiroService {

    @Autowired
    private TabuleiroRepository tabuleiroRepository;

    public Tabuleiro find(Long idTabuleiro) {
        return tabuleiroRepository.findById(idTabuleiro).orElse(null);
    }

    public void save(Tabuleiro tabuleiro) {
        tabuleiroRepository.save(tabuleiro);
    }

    public List<Tabuleiro> findAll() {
        return tabuleiroRepository.findAll();
    }

    public void delete(Tabuleiro tabuleiro) {
        tabuleiroRepository.delete(tabuleiro);
    }
}
