package br.com.fiap.WKStartupOne.Repository;

import br.com.fiap.WKStartupOne.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Integer> {

    UsuarioModel findByCpf(String cpf);

    UsuarioModel findByNome(String nome);

    UsuarioModel findByEmail(String email);

}
