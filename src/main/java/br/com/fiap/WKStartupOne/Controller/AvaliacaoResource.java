package br.com.fiap.WKStartupOne.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.WKStartupOne.Model.AvaliacaoModel;
import br.com.fiap.WKStartupOne.Repository.AvaliacaoRepository;
import br.com.fiap.WKStartupOne.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/avaliacao")
public class AvaliacaoResource {
    @Autowired
    AvaliacaoRepository avaliacaoRepo;
    
    @Autowired
    UsuarioRepository usuarioRepo;
    

    @GetMapping
    public List<AvaliacaoModel> buscarTodos(){
        return avaliacaoRepo.findAll();
    }
    
    @PostMapping
    public AvaliacaoModel criar(@RequestBody AvaliacaoModel avaliacao){
        return avaliacaoRepo.save(avaliacao);
    }


    //TODO: Criar rota para atualizar avaliacao
    @PutMapping("{id}")
    public AvaliacaoModel atualizar(@PathVariable Integer id, @RequestBody AvaliacaoModel avaliacao){
        avaliacao.setId(id);

        return avaliacaoRepo.save(avaliacao);
    }

    //TODO: Criar rota para deletar Avaliacao

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        avaliacaoRepo.deleteById(id);
    }
    //TODO: Criar rota para Listar avaliacoes de um usuario
    @GetMapping("/profissional/{id}")
    public List<AvaliacaoModel> buscarPorProfissional(@PathVariable Integer id){
        return usuarioRepo.findById(id).get().getAvaliacaoProfissional();

    }

    //TODO: Ver melhor forma para trazer listagem de avaliacoes
}
