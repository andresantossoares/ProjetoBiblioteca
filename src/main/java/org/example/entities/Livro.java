package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.aspectj.bridge.IMessage;


import java.util.Date;

@Data
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "li_for_id")
    private Fornecedor liFornecedor;

    @NotBlank(message = "Insira o nome do livro")
    @Size(max = 100, message = "O nome do livro excedeu o limite de caracteres")
    @Column(name = "LI_NOME")
    private String liNome;
    @NotBlank(message = "Insira a descrição do livro")
    @Size(max = 400, message = "A descrição do livro excedeu o limite de caracteres")
    @Column(name = "LI_DESC")
    private String liDescricao;
    @NotBlank(message = "Insira a Avaliação do livro")
    @Size(max = 30, message = "A avaliação do livro excedeu o limite de caracteres")
    @Column(name = "LI_AVALIA")
    private String liAvaliacao;
    private Integer liNumeropagi;

    @Size(max = 30, message = "A Linguagem do livro excedeu o limite de caracteres")
    @Column(name = "LI_IDIOMA")
    private String liIdioma;
    private Date liDataPubli;

    @Size(max = 70, message = "As Dimensões do livro excedeu o limite de caracteres")
    @Column(name = "LI_DIMENSOES")
    private String liDimensoes;

    @Size(max = 100, message = "O nome do autor do livro excedeu o limite de caracteres")
    @Column(name = "LI_AUTOR")
    private String liAutor;

    public Livro(Long liId, Fornecedor liFornecedor, String liNome, String liDescricao, String liAvaliacao, Integer liNumeropagi, String liIdioma, Date liDataPubli, String liDimensoes, String liAutor) {
        this.liId = liId;
        this.liFornecedor = liFornecedor;
        this.liNome = liNome;
        this.liDescricao = liDescricao;
        this.liAvaliacao = liAvaliacao;
        this.liNumeropagi = liNumeropagi;
        this.liIdioma = liIdioma;
        this.liDataPubli = liDataPubli;
        this.liDimensoes = liDimensoes;
        this.liAutor = liAutor;
    }
}
