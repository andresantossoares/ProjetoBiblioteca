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

/*
  Entidade que representa um Cliente no sistema.
  Um Cliente pode ter múltiplos Endereços e Contatos associados.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {

    /*
     Identificador único do cliente.
     É a chave primária da tabela CLIENTE, gerada automaticamente pelo banco.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    /*
      Lista de endereços associados ao cliente.
      O mapeamento é feito pelo atributo 'endCliente' na entidade Endereco.
      CascadeType.ALL garante que operações de persistência/remoção/merge
      feitas no Cliente sejam propagadas para os Endereços relacionados.
     */
    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    /*
      Lista de contatos associados ao cliente.
      O mapeamento é feito pelo atributo 'conCliente' na entidade Contato.
      CascadeType.ALL garante que operações de persistência/remoção/merge
      feitas no Cliente sejam propagadas para os Contatos relacionados.
     */
    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    /*
      Nome do cliente.
      Não pode ser nulo ou em branco e tem tamanho máximo de 100 caracteres.
     */
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "CLI_NOME", nullable = false, length = 100)
    private String cliNome;

    /*
      CPF do cliente.
     Não pode ser nulo ou em branco, deve ser válido e é único no banco.
     */
    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(name = "CLI_CPF", nullable = false, unique = true, length = 15)
    private String cliCpf;

    /*
      Construtor que inicializa o Cliente com id, nome e CPF.

      @param cliId  Identificador do cliente
      @param cliNome Nome do cliente
      @param cliCpf  CPF do cliente
     */
    public Cliente(Long cliId, String cliNome, String cliCpf) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
    }

}
