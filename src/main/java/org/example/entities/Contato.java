package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CON_CLI_ID")
    private Cliente conCliente;

    @Column(name = "CON_CELULAR", length = 15)
    private String conCelular;

    @Column(name = "CON_TELEFONE_COMERCIAL", length = 15)
    private String conTelefoneComercial;

    @Column(length = 55, name = "CON_EMAIL")
    private String conEmail;

    public Contato(Long conId, Cliente conCliente, String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conCliente = conCliente;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

}