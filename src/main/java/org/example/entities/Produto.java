package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 60,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o Nome")
    private String nome;
    @Size(max = 60,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a descrição")
    private String descricao;
    @Size(max = 50,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o codigo de barras")
    private Long codigo_barras;
    @Size(max = 40,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a referencia")
    private String referencia;
    @Size(max = 10,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a Unidade de medida")
    private String unidade_medida;
    @Size(max = 40,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a marca")
    private String marca;
    @Size(max = 40,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a categoria")
    private String categoria;
    @Size(max = 10,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o preço de custo")
    private Double preco_custo;
    @Size(max = 10,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o preço de venda")
    private Double preco_venda;
    @Size(max = 30,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o estoque atual")
    private Integer estoque_atual;
    @Size(max = 30,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o estoque minimo")
    private Integer estoque_minimo;
    @Size(max = 30,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o estoque maximo")
    private Integer estoque_maximo;
    @Size(max = 50,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira a localização")
    private String localizacao;
    @Size(max = 6,message = "Numero máximo de caracteres atingidos")
    private Date data_validade;
    @Size(max = 60,message = "Numero máximo de caracteres atingidos")
    private Long fornecedor_id;
    @Size(max = 20,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira se esta ativo ou não ativo")
    private boolean ativo;
    @Size(max = 6,message = "Numero máximo de caracteres atingidos")
    private Date data_cadastro;
    @Size(max = 120,message = "Numero máximo de caracteres atingidos")
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
