package org.example.services;

import org.example.entities.FormaPagamento;
import org.example.repositories.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;
    public List<FormaPagamento> findAll(){
        return repository.findAll();
    }

    public FormaPagamento findByID(Long id){
        Optional<FormaPagamento> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new RuntimeException("Forma de Pagamento não encontrada"));
    }

    public FormaPagamento Insert(FormaPagamento formaPagamento) {
        return repository.save(formaPagamento);
    }

    public FormaPagamento update(Long id, FormaPagamento novaFormaPagamento) {
        FormaPagamento exeistence = findByID(id);
        exeistence.setDescicao(novaFormaPagamento.getDescicao());
        exeistence.setDescicao(novaFormaPagamento.getTipo());
        exeistence.setTaxa_percentual(novaFormaPagamento.getTaxa_percentual());
        exeistence.setDias_entre_parcelas(novaFormaPagamento.getDias_entre_parcelas());
        exeistence.setNumero_parcelas(novaFormaPagamento.getNumero_parcelas());

        return repository.save(exeistence);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
