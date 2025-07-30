package org.example.controller;

import org.apache.coyote.Response;
import org.example.entities.FormaPagamento;
import org.example.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@RestController
@RequestMapping("/formapagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id")
    public ResponseEntity<FormaPagamento> findByid(@PathVariable Long id) {
        FormaPagamento formaPagamento = service.findByID(id);
        return ResponseEntity.ok().body(formaPagamento);
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> insert(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento novo = service.Insert(formaPagamento);
        return ResponseEntity.ok().body(novo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        FormaPagamento atualizado = service.update(id, formaPagamento);
        return ResponseEntity.ok().body(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }


}
