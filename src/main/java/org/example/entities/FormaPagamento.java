package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FORMAPAGAMENTO")
@Getter
@Setter
@NoArgsConstructor
public class FormaPagamento {

    private Long id;
    private String descicao;
    private String tipo;
    private Long numero_parcelas;
    private Integer dias_entre_parcelas;
    private boolean permite_troco;
    private  Double taxa_percentual;
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
