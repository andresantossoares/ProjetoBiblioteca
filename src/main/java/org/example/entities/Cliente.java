package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "CLI_NOME", nullable = false, length = 100)
    private String cliNome;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(name = "CLI_CPF", nullable = false, unique = true, length = 15)
    private String cliCpf;

    public Cliente(Long cliId, String cliNome, String cliCpf) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
    }

}


