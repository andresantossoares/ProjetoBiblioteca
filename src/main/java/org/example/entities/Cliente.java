package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String rg;
    private Date data_nascimento;
    private String sexo;
    private Date data_cadastro;
    private String observacoes;
    private boolean ativo;



    public Cliente( String nome, String cpf, String rg, Date data_nascimento, String sexo, Date data_cadastro, String observacoes, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.data_cadastro = data_cadastro;
        this.observacoes = observacoes;
        this.ativo = ativo;
    }

}


