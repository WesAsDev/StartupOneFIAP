package br.com.fiap.WKStartupOne.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.WKStartupOne.Model.AvaliacaoModel;
import br.com.fiap.WKStartupOne.Repository.AvaliacaoRepository;

@RestController
@RequestMapping("/api/v1/avaliacao")
public class AvaliacaoResource {
    @Autowired
    AvaliacaoRepository avaliacaoRepo;
    

    @GetMapping
    public List<AvaliacaoModel> buscarTodos(){
        return avaliacaoRepo.findAll();
    }
    
    @PostMapping
    public AvaliacaoModel criar(@RequestBody AvaliacaoModel avaliacao){
        return avaliacaoRepo.save(avaliacao);
    }


    //TODO: Criar rota para atualizar avaliacao

    //TODO: Criar rota para deletar Avaliacao

    //TODO: Criar rota para Listar avaliacoes de um usuario

    //TODO: Ver melhor forma para trazer listagem de avaliacoes
}
