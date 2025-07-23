package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PRODUTO")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Long codigo_barras;
    private String referencia;
    private String unidade_medida;
    private String marca;
    private String categoria;
    private Double preco_custo;
    private Double preco_venda;
    private Integer estoque_atual;
    private Integer estoque_minimo;
    private Integer estoque_maximo;
    private String localizacao;
    private Date data_validade;
    private Long fornecedor_id;
    private boolean ativo;
    private Date data_cadastro;
    private String observacoes;




    public Produto( String nome, String descricao, Long codigo_barras, String referencia, String unidade_medida, String marca, String categoria, Double preco_custo, Double preco_venda, Integer estoque_atual, Integer estoque_minimo, Integer estoque_maximo, String localizacao, Date data_validade, Long fornecedor_id, boolean ativo, Date data_cadastro, String observacoes) {

        this.nome = nome;
        this.descricao = descricao;
        this.codigo_barras = codigo_barras;
        this.referencia = referencia;
        this.unidade_medida = unidade_medida;
        this.marca = marca;
        this.categoria = categoria;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.estoque_atual = estoque_atual;
        this.estoque_minimo = estoque_minimo;
        this.estoque_maximo = estoque_maximo;
        this.localizacao = localizacao;
        this.data_validade = data_validade;
        this.fornecedor_id = fornecedor_id;
        this.ativo = ativo;
        this.data_cadastro = data_cadastro;
        this.observacoes = observacoes;
    }

}
