package org.example.controller;

import org.example.entities.Cliente;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> lista = service.findAll();
        return  ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = service.findByID(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
        Cliente novo = service.Insert(cliente);
return  ResponseEntity.ok().body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente atualizado = service.update(id, cliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
