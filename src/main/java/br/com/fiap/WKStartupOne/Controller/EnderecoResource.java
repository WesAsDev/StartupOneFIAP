package br.com.fiap.WKStartupOne.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.WKStartupOne.Model.EnderecoModel;
import br.com.fiap.WKStartupOne.Model.UsuarioModel;
import br.com.fiap.WKStartupOne.Repository.EnderecoRepository;
import br.com.fiap.WKStartupOne.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository enderecoRepo;

    @Autowired
    private UsuarioRepository userRepo;

    @GetMapping
    public List<EnderecoModel> buscarTodos(){
        return enderecoRepo.findAll();
    }

    //TODO mudar mapeamento do endereco e combinar com mapeamento de usuario
    @PostMapping("cliente/{id}")
    public EnderecoModel criarEndereco(@PathVariable Integer id, @RequestBody EnderecoModel endereco){
        Optional<UsuarioModel> userOpt = userRepo.findById(id);
        UsuarioModel usM = new UsuarioModel();
        if(!userOpt.isEmpty()){
            usM = userOpt.get();
        }

        endereco.setUsuario(usM);

        return enderecoRepo.save(endereco);
    }


    @PutMapping("cliente/{id}")
    public EnderecoModel atualizarEnderecoPorUsuario(@PathVariable Integer id, @RequestBody EnderecoModel endereco){
        Optional<UsuarioModel> userOpt = userRepo.findById(id);
        UsuarioModel usM = new UsuarioModel();
        if(!userOpt.isEmpty()){
            usM = userOpt.get();
            
        }

        endereco.setId(usM.getEndereco().getId());

        return enderecoRepo.save(endereco);
    }
}
