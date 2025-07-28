package org.example.services;

import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;
    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    public Fornecedor findByID(Long id){
        Optional<Fornecedor> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor Insert(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor update(Long id, Fornecedor novoFornecedor) {
        Fornecedor exeistence = findByID(id);
        exeistence.setNome_fantasia(novoFornecedor.getNome_fantasia());
        exeistence.setCnpj(novoFornecedor.getCnpj());
        exeistence.setContato_responsavel(novoFornecedor.getContato_responsavel());
        exeistence.setInscricao_estadual(novoFornecedor.getInscricao_estadual());
        exeistence.setRazao_social(novoFornecedor.getRazao_social());
        exeistence.setInscricao_municipal(novoFornecedor.getInscricao_municipal());
        exeistence.setData_cadastro(novoFornecedor.getData_cadastro());
        exeistence.setObservacoes(novoFornecedor.getObservacoes());

        return repository.save(exeistence);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
