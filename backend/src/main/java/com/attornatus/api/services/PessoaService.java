package com.attornatus.api.services;

import com.attornatus.api.entities.Pessoa;
import com.attornatus.api.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa getId(Long pessoa_id){
        return repository.getReferenceById(pessoa_id);
    }

    @Transactional
    public Pessoa update(Long pessoa_id){
        Pessoa pessoa = getId(pessoa_id);
        pessoa.setNome(pessoa.getNome());
        pessoa.setDataNascimento(pessoa.getDataNascimento());

        return pessoa;
    }

    public Page<Pessoa> findAll(Pageable paginacao) {
        return repository.findAll(paginacao);
    }


    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(Pessoa pessoa) {
        repository.delete(pessoa);
    }

    public Page<Pessoa> findByCep(String cep, Pageable paginacao) {
        return repository.findByEnderecoCep(cep, paginacao);
    }

}
