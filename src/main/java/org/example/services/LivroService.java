package org.example.services;

import org.example.dto.LivroDTO;
import org.example.entities.Fornecedor;
import org.example.entities.Livro;
import org.example.repositories.EnderecoRepository;
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
            obj.setLiId(null);

            // Salva o fornecedor primeiro
            if (obj.getLiFornecedor() != null) {
                Fornecedor fornecedorSalvo = fornecedorRepository.save(obj.getLiFornecedor());
                obj.setLiFornecedor(fornecedorSalvo);
            }

            // Agora salva o livro
            obj = livroRepository.save(obj);

            return obj;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }


    public Livro update(Long id, LivroDTO objDto) {
        try {
            Livro entity = findById(id);

            entity.setLiNome(objDto.getLiNome());
            entity.setLiDescricao(objDto.getLiDescricao());
            entity.setLiAvaliacao(objDto.getLiAvaliacao());
            entity.setLiNumeropagi(objDto.getLiNumeropagi());

            if (entity.getLiFornecedor() == null) {
                entity.setLiFornecedor(new Fornecedor());
            }

            Fornecedor fornecedor = entity.getLiFornecedor();
            fornecedor.setForNomeFantasia(objDto.getForNomeFantasia());
            fornecedor.setForCnpj(objDto.getForCnpj());
            fornecedor.setForRazaoSocial(objDto.getForRazaoSocial());

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
        livro.setLiNumeropagi(objDto.getLiNumeropagi());

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
        dto.setLiNumeropagi(obj.getLiNumeropagi());

        if (obj.getLiFornecedor() != null) {
            dto.setForNomeFantasia(obj.getLiFornecedor().getForNomeFantasia());
            dto.setForCnpj(obj.getLiFornecedor().getForCnpj());
            dto.setForRazaoSocial(obj.getLiFornecedor().getForRazaoSocial());
        }

        return dto;
    }
}
