package org.example.services;

import org.example.dto.LivroDTO;
import org.example.entities.Fornecedor;
import org.example.entities.Livro;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.LivroRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Livro insert(Livro obj) {
        try {
            obj.setLiId(null); // garante que o livro será criado como novo

            if (obj.getLiFornecedor() != null) {
                String cnpj = obj.getLiFornecedor().getForCnpj();

                // Verifica se já existe um fornecedor com o mesmo CNPJ
                Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findByForCnpj(cnpj);

                if (fornecedorExistente.isPresent()) {
                    // Usa o fornecedor já existente
                    obj.setLiFornecedor(fornecedorExistente.get());
                } else {
                    // Salva novo fornecedor
                    Fornecedor novoFornecedor = fornecedorRepository.save(obj.getLiFornecedor());
                    obj.setLiFornecedor(novoFornecedor);
                }
            }

            // Agora salva o livro com o fornecedor já tratado
            return livroRepository.save(obj);

        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException("Erro ao salvar livro ou fornecedor: " + e.getMessage());
        }
    }

    public Livro update(Long id, LivroDTO objDto) {
        try {
            Livro entity = findById(id);

            entity.setLiNome(objDto.getLiNome());
            entity.setLiDescricao(objDto.getLiDescricao());
            entity.setLiAvaliacao(objDto.getLiAvaliacao());
            entity.setLiNumeroPagi(objDto.getLiNumeropagi());

            if (entity.getLiFornecedor() == null) {
                entity.setLiFornecedor(new Fornecedor());
            }

            Fornecedor fornecedor = entity.getLiFornecedor();
            fornecedor.setForNomeFantasia(objDto.getForNomeFantasia());
            fornecedor.setForCnpj(objDto.getForCnpj());
            fornecedor.setForRazaoSocial(objDto.getForRazaoSocial());

            // Atualiza fornecedor no banco
            fornecedorRepository.save(fornecedor);

            return livroRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteLivro(Long id) {
        try {
            livroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Livro fromDTO(LivroDTO objDto) {
        Livro livro = new Livro();
        livro.setLiId(null);
        livro.setLiNome(objDto.getLiNome());
        livro.setLiDescricao(objDto.getLiDescricao());
        livro.setLiAvaliacao(objDto.getLiAvaliacao());
        livro.setLiNumeroPagi(objDto.getLiNumeropagi());

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setForId(null);
        fornecedor.setForNomeFantasia(objDto.getForNomeFantasia());
        fornecedor.setForCnpj(objDto.getForCnpj());
        fornecedor.setForRazaoSocial(objDto.getForRazaoSocial());

        livro.setLiFornecedor(fornecedor);

        return livro;
    }

    public LivroDTO toNewDTO(Livro obj) {
        LivroDTO dto = new LivroDTO();

        dto.setLiId(obj.getLiId());
        dto.setLiNome(obj.getLiNome());
        dto.setLiDescricao(obj.getLiDescricao());
        dto.setLiAvaliacao(obj.getLiAvaliacao());
        dto.setLiNumeropagi(obj.getLiNumeroPagi());

        if (obj.getLiFornecedor() != null) {
            dto.setForNomeFantasia(obj.getLiFornecedor().getForNomeFantasia());
            dto.setForCnpj(obj.getLiFornecedor().getForCnpj());
            dto.setForRazaoSocial(obj.getLiFornecedor().getForRazaoSocial());
        }

        return dto;
    }
}
