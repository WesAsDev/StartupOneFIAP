package br.com.fiap.WKStartupOne.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;



@Entity
public class EnderecoModel {

    public EnderecoModel(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ENDERECO_ID")
    private Integer id;

    @NotNull(message = "Endereço não pode estar vazio!")
    private String endereco;

    @NotNull(message = "CEP não pode estar vazio!")
    private Integer cep;
    
    private Integer numero;


    //FIXME: Arrumar relação endereço-usuario
    // @OneToOne(mappedBy = "endereco")
    // private UsuarioModel usuario;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private UsuarioModel usuario;

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
