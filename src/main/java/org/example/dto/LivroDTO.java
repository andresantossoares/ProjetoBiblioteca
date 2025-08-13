package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
public class LivroDTO {

    private Long liId;
    private String liNome;
    private String liDescricao;
    private String liAvaliacao;
    private Integer liNumeropagi;
    private String forNomeFantasia;
    @CNPJ private String forCnpj;
    private String forRazaoSocial;

}
