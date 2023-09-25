package br.com.fiap.WKStartupOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.WKStartupOne.Model.ServicoModel;
import br.com.fiap.WKStartupOne.Model.UsuarioModel;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel, Integer> {
    ServicoModel findByTipo(String tipo);
    ServicoModel findByStatus(String status);
    ServicoModel findByCliente(UsuarioModel cliente);
    ServicoModel findByProfissional(UsuarioModel profissional);
}
