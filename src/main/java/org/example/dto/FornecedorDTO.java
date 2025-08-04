package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FornecedorDTO {
    @Size(max = 100, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Coloque uma rua")
    private String rua;
    @Size(max = 6, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o numero da rua")
    private String numero;
    @Size(max = 8, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu cep")
    private String cep;
    @Size(max = 100, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "insira a razão social")
    private String razao_social;
    @Size(max = 60, message = "Numero máximo de caracteres atingidos")
    private String nome_fantasia;
    @Size(max = 14, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o cnpj")
    private String cnpj;
    @Size(max = 9, message = "Máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu numero de celular")
    private String celular;

    public FornecedorDTO(String rua, String numero, String cep, String razao_social, String nome_fantasia, String cnpj, String celular) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.celular = celular;
    }
}