package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario find(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public Usuario findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
