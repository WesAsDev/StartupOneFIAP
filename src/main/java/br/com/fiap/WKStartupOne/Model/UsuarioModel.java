package br.com.fiap.WKStartupOne.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@SequenceGenerator(name = "usuario", sequenceName= "SQ_USUARIO", allocationSize = 1)
@Entity
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USUARIO_ID")
    private int id;

    public UsuarioModel(){

    }

    public UsuarioModel(int id){
        this.id = id;
    }

    public UsuarioModel(int id, String nome, String cpf, String email, String senha, String tipo, int endereco){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        
    }

    

    @NotBlank(message = "Nome não pode estar vazio!")
    @NotNull
    private String nome;

    @NotBlank(message = "CPF não pode estar vazio!")
    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "Email não pode estar vazio!")
    @NotNull
    @Email(message = "Email não está formatado corretamente!")
    @Column(unique = true)
    private String email;

    @NotNull
    private String tipo;

    @NotBlank(message = "Senha não pode estar vazio!")
    @NotNull
    private String senha;

    @JsonManagedReference(value="servico_cliente")
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<ServicoModel> servicosCliente = new ArrayList<>();

    @JsonManagedReference(value="servico_profissional")
    @OneToMany(mappedBy = "profissional",cascade = CascadeType.ALL)
    private List<ServicoModel> servicosProfissional = new ArrayList<>();

    @JsonManagedReference(value="cliente_id")
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<AvaliacaoModel> avaliacaoCliente = new ArrayList<>();

    @JsonManagedReference(value="profissional_id")
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<AvaliacaoModel> avaliacaoProfissional = new ArrayList<>();

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "ENDERECO_ID")
    // private EnderecoModel endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EnderecoModel endereco;

    

     public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo_usuario){
        this.tipo = tipo_usuario;
    }

    public String getTipo(){
        return this.tipo;
    }

    public List<ServicoModel> getServicosCliente() {
        return servicosCliente;
    }

    public void setServicosCliente(List<ServicoModel> servicosCliente) {
        this.servicosCliente = servicosCliente;
    }

    public List<ServicoModel> getServicosProfissional() {
        return servicosProfissional;
    }

    public void setServicosProfissional(List<ServicoModel> servicosProfissional) {
        this.servicosProfissional = servicosProfissional;
    }

    public List<AvaliacaoModel> getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public void setAvaliacaoCliente(List<AvaliacaoModel> avaliacaoCliente) {
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public List<AvaliacaoModel> getAvaliacaoProfissional() {
        return avaliacaoProfissional;
    }

    public void setAvaliacaoProfissional(List<AvaliacaoModel> avaliacaoProfissional) {
        this.avaliacaoProfissional = avaliacaoProfissional;
    }

}
