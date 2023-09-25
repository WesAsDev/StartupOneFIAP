package br.com.fiap.WKStartupOne.Repository;

import br.com.fiap.WKStartupOne.Model.AvaliacaoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel,Integer> {

}
