package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FORMAPAGAMENTO")
@Getter
@Setter
@NoArgsConstructor
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 150,message = "Numero máximo de caracteres atingidos")
    private String descricao;
    @Size(max = 50,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o tipo do pagamento")
    private String tipo;

    private Long numero_parcelas;

    private Integer dias_entre_parcelas;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se vai permitir troco ou não")
    private String permite_troco;

    private Double taxa_percentual;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se esta ativo ou não ativo")
    private String ativo;

    public FormaPagamento(String descricao, String tipo, Long numero_parcelas, Integer dias_entre_parcelas, String permite_troco, Double taxa_percentual, String ativo) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.numero_parcelas = numero_parcelas;
        this.dias_entre_parcelas = dias_entre_parcelas;
        this.permite_troco = permite_troco;
        this.taxa_percentual = taxa_percentual;
        this.ativo = ativo;
    }

}