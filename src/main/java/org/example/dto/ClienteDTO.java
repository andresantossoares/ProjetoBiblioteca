package org.example.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Table
@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long cliId;
    private String cliNome;

    @CPF(message = "CPF inválido")
    private String cliCpf;

    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;

    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;

}
