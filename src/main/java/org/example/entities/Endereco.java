package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Long endId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "END_CLI_ID")
    private Cliente endCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "END_FOR_ID")
    private Fornecedor endFornecedor;

    @Column(name = "END_RUA")
    private String endRua;

    @Column(name = "END_NUMERO")
    private String endNumero;

    @Column(name = "END_CIDADE")
    private String endCidade;

    @Column(name = "END_CEP", length = 9)
    private String endCep;

    @Column(name = "END_ESTADO", length = 124)
    private String endEstado;



    public Endereco(Long endId, Cliente endCliente, String endRua, String endNumero, String endCidade, String endCep, String endEstado) {
        this.endId = endId;
        this.endCliente = endCliente;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCidade = endCidade;
        this.endCep = endCep;
        this.endEstado = endEstado;
    }

    public Endereco(Long endId, Fornecedor endFornecedor, String endRua, String endNumero, String endCidade, String endCep, String endEstado) {
        this.endId = endId;
        this.endFornecedor = endFornecedor;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCidade = endCidade;
        this.endCep = endCep;
        this.endEstado = endEstado;
    }
}