package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "FORNECEDOR")
@Getter
@Setter
@NoArgsConstructor
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razao_social;
    private String nome_fantasia;
    private String cnpj;
    private String inscricao_estadual;
    private String inscricao_municipal;
    private String contato_responsavel;
    private Date data_cadastro;
    private String observacoes;
    private boolean ativo;

    public Fornecedor( String razao_social, String nome_fantasia, String cnpj, String inscricao_estadual, String inscricao_municipal, String contato_responsavel, Date data_cadastro, String observacoes, boolean ativo) {

        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.inscricao_estadual = inscricao_estadual;
        this.inscricao_municipal = inscricao_municipal;
        this.contato_responsavel = contato_responsavel;
        this.data_cadastro = data_cadastro;
        this.observacoes = observacoes;
        this.ativo = ativo;
    }


}

