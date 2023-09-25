package br.com.fiap.WKStartupOne.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import br.com.fiap.WKStartupOne.Model.ServicoModel;
import br.com.fiap.WKStartupOne.Repository.ServicoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/servico")
@DynamicUpdate
public class ServicoResource {

    @Autowired
    private ServicoRepository servicoRepo;

    @GetMapping
    public List<ServicoModel> buscarTodos(){
        return servicoRepo.findAll();
    }

    @PostMapping
    public ServicoModel criarServico(@RequestBody ServicoModel servico) {
        return servicoRepo.save(servico);
    }

    //FIXME: Arrumar a atualização de serviço
    @PutMapping("{id}")
    public ServicoModel atualizarServico(@RequestBody ServicoModel servico, @PathVariable Integer id) {
        servico.setId(id);
        return servicoRepo.saveAndFlush(servico);
    }

    //TODO: Criar rota para deletar servico
    

}
