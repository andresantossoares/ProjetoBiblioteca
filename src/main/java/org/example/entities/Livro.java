package org.example.entities;

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
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LI_ID")
    private Long liId;
    @NotBlank(message = "Insira o nome do livro")
    @Size(max = 100, message = "O nome do livro excedeu o limite de caracteres")
    @Column(name = "LI_NOME")
    private String liNome;
    @NotBlank(message = "Insira a descrição do livro")
    @Size(max = 400, message = "A descrição do livro excedeu o limite de caracteres")
    @Column(name = "LI_DESC")
    private String liDescricao;
    private Long liPreco;
    @NotBlank(message = "Insira a Avaliação do livro")
    @Size(max = 30, message = "A avaliação do livro excedeu o limite de caracteres")
    @Column(name = "LI_AVALIA")
    private String liAvaliacao;
    @NotBlank(message = "Insira a Editora do livro")
    @Size(max = 30, message = "A Editora do livro excedeu o limite de caracteres")
    @Column(name = "LI_EDIT")
    private String liEditora;
    private Integer liNumeropagi;
    @NotBlank(message = "Insira a Linguagem do livro")
    @Size(max = 30, message = "A Linguagem do livro excedeu o limite de caracteres")
    @Column(name = "LI_IDIOMA")
    private String liIdioma;
    private Date liDataPubli;
    @NotBlank(message = "Insira as Dimensões do livro")
    @Size(max = 70, message = "As Dimensões do livro excedeu o limite de caracteres")
    @Column(name = "LI_DIMENSOES")
    private String liDimensoes;
    @NotBlank(message = "Insira o nome do autor do livro")
    @Size(max = 100, message = "O nome do autor do livro excedeu o limite de caracteres")
    @Column(name = "LI_AUTOR")
    private String liAutor;


}
