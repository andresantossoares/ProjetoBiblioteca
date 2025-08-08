package org.example.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
public class FornecedorDTO {

    private Long forId;
    private String forNomeFantasia;
    @CNPJ(message = "CNPJ inválido")
    private String forCnpj;
    private String forRazaoSocial;

    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;

    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;


}