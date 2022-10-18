package br.ufsm.tcc2.pmmaster.repository;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    Usuario findByNome(String nome);
}
