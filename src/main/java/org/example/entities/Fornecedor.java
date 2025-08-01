package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 100,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "insira a razão social")
    private String razao_social;
    @Size(max = 60,message = "Numero máximo de caracteres atingidos")
    private String nome_fantasia;
    @Size(max = 14,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o cnpj")
    private String cnpj;
    @Size(max = 14,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a inscrição estadual")
    private String inscricao_estadual;
    @Size(max = 15,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a inscrição municipal")
    private String inscricao_municipal;
    @Size(max = 6,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Coloque a data de cadastro")
    private Date data_cadastro;
    @Size(max = 150,message = "Numero máximo de caracteres atingidos")
    private String observacoes;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se esta ativo ou não ativo")
    private boolean ativo;

    public Fornecedor( String razao_social, String nome_fantasia, String cnpj, String inscricao_estadual, String inscricao_municipal, Date data_cadastro, String observacoes, boolean ativo) {

        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.inscricao_estadual = inscricao_estadual;
        this.inscricao_municipal = inscricao_municipal;
        this.data_cadastro = data_cadastro;
        this.observacoes = observacoes;
        this.ativo = ativo;
    }


}

