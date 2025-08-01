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
    private String descicao;
    @Size(max = 50,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o tipo do pagamento")
    private String tipo;
    @Size(max = 4,message = "Numero máximo de caracteres atingidos")
    private Long numero_parcelas;
    @Size(max = 3,message = "Numero máximo de caracteres atingidos")
    private Integer dias_entre_parcelas;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se vai permitir troco ou não")
    private boolean permite_troco;
    @Size(max = 10,message = "Numero máximo de caracteres atingidos")
    private  Double taxa_percentual;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se esta ativo ou não ativo")
    private boolean ativo;

    public FormaPagamento(String descicao, String tipo, Long numero_parcelas, Integer dias_entre_parcelas, boolean permite_troco, Double taxa_percentual, boolean ativo) {
        this.descicao = descicao;
        this.tipo = tipo;
        this.numero_parcelas = numero_parcelas;
        this.dias_entre_parcelas = dias_entre_parcelas;
        this.permite_troco = permite_troco;
        this.taxa_percentual = taxa_percentual;
        this.ativo = ativo;
    }
}
