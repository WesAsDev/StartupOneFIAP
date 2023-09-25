package br.com.fiap.WKStartupOne.Controller;

import br.com.fiap.WKStartupOne.Model.UsuarioModel;
import br.com.fiap.WKStartupOne.Repository.UsuarioRepository;
import br.com.fiap.WKStartupOne.Utils.PasswordUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioRepository usuarioRepo;


    @GetMapping
    public List<UsuarioModel> buscarTodos(){
        return usuarioRepo.findAll();
    }

    @GetMapping("pesquisa")
    public UsuarioModel buscarCpf(@RequestParam(required = false) String cpf, @RequestParam(required = false) String nome){
        return usuarioRepo.findByCpf(cpf);
    }

    @GetMapping({"/find"})
    public UsuarioModel buscarEmail(@RequestParam String email){
        return usuarioRepo.findByEmail(email);
    }

    @GetMapping("profissional/{id}")
    public UsuarioModel buscarProfissional(@RequestParam Integer id){
        return usuarioRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel user){

        String hashSenha = PasswordUtils.hashPassword(user.getSenha());

        user.setSenha(hashSenha);

        return usuarioRepo.save(user);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Boolean logarUsuario(@RequestBody UsuarioModel user){
        System.out.println(user.getEmail());
        System.out.println(usuarioRepo.findByEmail(user.getEmail()));
    
        String hash = usuarioRepo.findByEmail(user.getEmail()).getSenha();

        Boolean logado = PasswordUtils.checkPassword(user.getSenha(), hash);

        return logado;
    }


    //FIXME: Concertar atualização de usuario que atualiza a senha sem hash
    @PutMapping({"{id}"})
    public ResponseEntity<String> atualizarUsuario(@RequestBody UsuarioModel user, @PathVariable Integer id){
        user.setId(id);
        user = usuarioRepo.save(user);
        return ResponseEntity.ok("Usuario "+ user.getEmail() +" atualizado com sucesso") ;
    }

    @DeleteMapping({"{id}"})
    public void remover(@PathVariable Integer id){
        usuarioRepo.deleteById(id);
    }
}
