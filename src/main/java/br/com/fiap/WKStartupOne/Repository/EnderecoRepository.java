package br.com.fiap.WKStartupOne.Repository;

import br.com.fiap.WKStartupOne.Model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel,Integer> {


}
