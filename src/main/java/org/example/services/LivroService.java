package org.example.services;

import org.example.entities.Livro;
import org.example.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado para exclusão. ID: " + id);
        }
        repository.deleteById(id);
    }

    public Livro update(Long id, Livro livroAtualizado) {
        return repository.findById(id)
                .map(livro -> {
                    livro.setLiNome(livroAtualizado.getLiNome());
                    livro.setLiDescricao(livroAtualizado.getLiDescricao());
                    livro.setLiPreco(livroAtualizado.getLiPreco());
                    livro.setLiAvaliacao(livroAtualizado.getLiAvaliacao());
                    livro.setLiEditora(livroAtualizado.getLiEditora());
                    livro.setLiNumeropagi(livroAtualizado.getLiNumeropagi());
                    livro.setLiIdioma(livroAtualizado.getLiIdioma());
                    livro.setLiDataPubli(livroAtualizado.getLiDataPubli());
                    livro.setLiDimensoes(livroAtualizado.getLiDimensoes());
                    livro.setLiAutor(livroAtualizado.getLiAutor());
                    return repository.save(livro);
                })
                .orElseThrow(() -> new RuntimeException("Livro não encontrado para atualização. ID: " + id));
    }
}
