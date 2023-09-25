package br.com.fiap.WKStartupOne.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class AvaliacaoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double Avaliacao;

    public AvaliacaoModel(){}
    
    public AvaliacaoModel(int id, Double Avaliacao, int cliente, int profissional){
        System.out.println(cliente);
        System.out.println(profissional);
        this.cliente = new UsuarioModel(cliente);
        this.profissional = new UsuarioModel(profissional);
        this.Avaliacao = Avaliacao;
    }


    @JsonBackReference(value="cliente_id")
    @ManyToOne
    @JoinColumn(name="cliente_usuario_id")
    private UsuarioModel cliente;

    @JsonBackReference(value="profissional_id")
    @ManyToOne
    @JoinColumn(name="profissional_usuario_id")
    private UsuarioModel profissional;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        Avaliacao = avaliacao;
    }

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }

    public UsuarioModel getProfissional() {
        return profissional;
    }

    public void setProfissional(UsuarioModel profissional) {
        this.profissional = profissional;
    }

}
