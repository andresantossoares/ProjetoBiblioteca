package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTATO")
@Getter
@Setter
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 8,message = "Máximo de caracteres atingidos")
    private String telefone;
    @Size(max = 9,message = "Máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu numero de celular")
    private String celular;
    @Size(max = 120,message = "Máximo de caracteres atingidos")
    @NotBlank(message = "Coloque seu email")
    private String email;


    public Contato(Long id, String telefone, String celular, String email) {
        this.id = id;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }
}
