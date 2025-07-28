package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findByID(Long id){
        Optional<Produto> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto Insert(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Long id, Produto novoProduto) {
        Produto exeistence = findByID(id);
        exeistence.setCategoria(novoProduto.getCategoria());
        exeistence.setDescricao(novoProduto.getDescricao());
        exeistence.setNome(novoProduto.getNome());
        exeistence.setMarca(novoProduto.getMarca());
        exeistence.setLocalizacao(novoProduto.getLocalizacao());
        exeistence.setReferencia(novoProduto.getReferencia());
        exeistence.setUnidade_medida(novoProduto.getUnidade_medida());
        exeistence.setData_validade(novoProduto.getData_validade());
        exeistence.setCodigo_barras(novoProduto.getCodigo_barras());
        exeistence.setEstoque_atual(novoProduto.getEstoque_atual());
        exeistence.setEstoque_maximo(novoProduto.getEstoque_maximo());
        exeistence.setEstoque_minimo(novoProduto.getEstoque_minimo());
        exeistence.setFornecedor_id(novoProduto.getFornecedor_id());
        exeistence.setPreco_custo(novoProduto.getPreco_custo());
        exeistence.setPreco_venda(novoProduto.getPreco_venda());
        exeistence.setData_cadastro(novoProduto.getData_cadastro());
        exeistence.setObservacoes(novoProduto.getObservacoes());

        return repository.save(exeistence);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
