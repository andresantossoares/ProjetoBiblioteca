package org.example.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    @Size(max = 60, message = "O numero maximo de caracteres de 60 foi atingido")
    @NotBlank(message = "Insira o nome")
    private String nome;
    @Size(max = 14,message = "Voce atingiu o limite de caracteres")
    @NotBlank(message = "Insira o CPF")
    private String cpf;
    @Size(max = 11,message = "Voce atingiu o limite de caracteres")
    @NotBlank(message = "Insira o Rg")
    private String rg;
    @Size(max = 100,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Coloque uma rua")
    private String rua;
    @Size(max = 6, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o numero da rua")
    private String numero;
    @Size(max = 8,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu cep")
    private String cep;
    @Size(max = 8,message = "Máximo de caracteres atingidos")
    private String telefone;
    @Size(max = 9,message = "Máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu numero de celular")
    private String celular;


    public ClienteDTO(String celular, String telefone, String cep, String numero, String rua, String rg, String cpf, String nome) {
        this.celular = celular;
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
    }
}
