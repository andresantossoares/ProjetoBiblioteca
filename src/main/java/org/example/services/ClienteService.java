package org.example.services;

import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
private ClienteRepository repository;
public List<Cliente> findAll(){
    return repository.findAll();
}

public Cliente findByID(Long id){
    Optional<Cliente> obj = repository.findById(id);
    return  obj.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
}

public Cliente Insert(Cliente cliente) {
    return repository.save(cliente);
}

public Cliente update(Long id, Cliente novoCliente) {
    Cliente exeistence = findByID(id);
    exeistence.setNome(novoCliente.getNome());
    exeistence.setCpf(novoCliente.getCpf());
    exeistence.setRg(novoCliente.getRg());
    exeistence.setSexo(novoCliente.getSexo());
    exeistence.setObservacoes(novoCliente.getObservacoes());
    exeistence.setData_cadastro(novoCliente.getData_cadastro());
    exeistence.setData_nascimento(novoCliente.getData_nascimento());

    return repository.save(exeistence);
}
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
