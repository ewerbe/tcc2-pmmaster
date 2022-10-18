package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.AreaConhecimento;
import br.ufsm.tcc2.pmmaster.repository.AreaConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaConhecimentoService {

    @Autowired
    AreaConhecimentoRepository areaConhecimentoRepository;

    public AreaConhecimento find(Long idAreaConhecimento) {
        return areaConhecimentoRepository.findById(idAreaConhecimento).orElse(null);
    }

    public void save(AreaConhecimento areaConhecimento) {
        areaConhecimentoRepository.save(areaConhecimento);
    }

    public List<AreaConhecimento> findAll() {
        return areaConhecimentoRepository.findAll();
    }

    public void delete(AreaConhecimento areaConhecimento) {
        areaConhecimentoRepository.delete(areaConhecimento);
    }
}
