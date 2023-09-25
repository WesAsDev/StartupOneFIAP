package br.com.fiap.WKStartupOne.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "servico", sequenceName = "SQ_SERVICO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicoModel {
    
    public ServicoModel(){}
    
    public ServicoModel(int id, String tipo, Date data, String status, Double orcamento, int cliente, int profissional){
        System.out.println(cliente);
        System.out.println(profissional);
        this.cliente = new UsuarioModel(cliente);
        this.profissional = new UsuarioModel(profissional);

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
    private int id;



    private String tipo;
    private Date data;
    private String status;
    private Double orcamento;


    @JsonBackReference(value="servico_cliente")
    @ManyToOne
    @JoinColumn(name="cliente_usuario_id")
    private UsuarioModel cliente;

    @JsonBackReference(value="servico_profissional")
    @ManyToOne
    @JoinColumn(name="profissional_usuario_id")
    private UsuarioModel profissional;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Date getData(){
        return this.data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setOrcamento(Double orcamento){
        this.orcamento = orcamento;
    }

    public Double getOrcamento(){
        return this.orcamento;
    }

    public void setCliente(UsuarioModel cliente){
        this.cliente = cliente;
    }

    public UsuarioModel getCliente(){
        return this.cliente;
    }

    public void setProfissional(UsuarioModel profissional){
        this.profissional = profissional;
    }
    
    public UsuarioModel getProfissional(){
        return this.profissional;
    }

}
