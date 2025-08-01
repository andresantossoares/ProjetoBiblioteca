package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Size(max = 60, message = "O numero maximo de caracteres de 60 foi atingido")
    @NotBlank(message = "Insira o nome")
    private String nome;
    @Size(max = 14,message = "Voce atingiu o limite de caracteres")
    @NotBlank(message = "Insira o CPF")
    private String cpf;
    @Size(max = 11,message = "Voce atingiu o limite de caracteres")
    @NotBlank(message = "Insira o Rg")
    private String rg;
    @Size(max = 6,message = "Limite de numeros atingidos")
    @NotBlank(message = "insira sua data de nascimento")
    private Date data_nascimento;
    @NotBlank(message = "Insira seu sexo")
    private String sexo;

    private Date data_cadastro;
    @Size(max = 100,message = "Limite de caracteres atingidos")
    private String observacoes;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se esta ativo ou não ativo")
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


