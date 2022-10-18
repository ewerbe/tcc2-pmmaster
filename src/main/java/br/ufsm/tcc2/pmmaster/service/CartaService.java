package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.Carta;
import br.ufsm.tcc2.pmmaster.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    public Carta find(Long idCarta) {
        return cartaRepository.findById(idCarta).orElse(null);
    }

    public void save(Carta carta) {
        cartaRepository.save(carta);
    }

    public List<Carta> findAll() {
        return cartaRepository.findAll();
    }

    public void delete(Carta carta) {
        cartaRepository.delete(carta);
    }
}
