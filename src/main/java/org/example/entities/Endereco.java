package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENDERECO")
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Coloque uma rua")
    private String rua;
    @Size(max = 6, message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira o numero da rua")
    private String numero;
    @Size(max = 75,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira um bairro")
    private String bairro;
    @Size(max = 60,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Coloque uma cidade")
    private String cidade;
    @Size(max = 50,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu estado")
    private String estado;
    @Size(max = 8,message = "Numero máximo de caracteres atingidos")
    @NotBlank(message = "Insira seu cep")
    private String cep;

    public Endereco(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
