package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "LIVRO")
@Getter
@Setter
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LI_ID")
    private Long liId;

    @ManyToOne
    @JoinColumn(name = "LI_FOR_ID", nullable = false)
    @JsonIgnore // evita recursão infinita com Fornecedor → Livro → Fornecedor
    private Fornecedor liFornecedor;

    @NotBlank(message = "Insira o nome do livro")
    @Size(max = 100, message = "O nome do livro excedeu o limite de caracteres")
    @Column(name = "LI_NOME", nullable = false, length = 100)
    private String liNome;

    @NotBlank(message = "Insira a descrição do livro")
    @Size(max = 400, message = "A descrição do livro excedeu o limite de caracteres")
    @Column(name = "LI_DESC", nullable = false, length = 400)
    private String liDescricao;

    @NotBlank(message = "Insira a avaliação do livro")
    @Size(max = 30, message = "A avaliação do livro excedeu o limite de caracteres")
    @Column(name = "LI_AVALIA", nullable = false, length = 30)
    private String liAvaliacao;

    @Column(name = "LI_NUM_PAGI")
    private Integer liNumeroPagi;

    @Size(max = 30, message = "O idioma do livro excedeu o limite de caracteres")
    @Column(name = "LI_IDIOMA", length = 30)
    private String liIdioma;

    @Temporal(TemporalType.DATE)
    @Column(name = "LI_DATA_PUBLI")
    private Date liDataPubli;

    @Size(max = 70, message = "As dimensões do livro excederam o limite de caracteres")
    @Column(name = "LI_DIMENSOES", length = 70)
    private String liDimensoes;

    @Size(max = 100, message = "O nome do autor excedeu o limite de caracteres")
    @Column(name = "LI_AUTOR", length = 100)
    private String liAutor;

    public Livro(Long liId, Fornecedor liFornecedor, String liNome, String liDescricao, String liAvaliacao, Integer liNumeroPagi, String liIdioma, Date liDataPubli, String liDimensoes, String liAutor) {
        this.liId = liId;
        this.liFornecedor = liFornecedor;
        this.liNome = liNome;
        this.liDescricao = liDescricao;
        this.liAvaliacao = liAvaliacao;
        this.liNumeroPagi = liNumeroPagi;
        this.liIdioma = liIdioma;
        this.liDataPubli = liDataPubli;
        this.liDimensoes = liDimensoes;
        this.liAutor = liAutor;
    }
}