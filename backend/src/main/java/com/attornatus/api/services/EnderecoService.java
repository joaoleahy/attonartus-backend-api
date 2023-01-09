package com.attornatus.api.services;

import com.attornatus.api.entities.Endereco;
import com.attornatus.api.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Optional<Endereco> findById(Long id) {
        return repository.findById(id);
    }

    public List<Endereco> findByCep(String cep){
        return repository.findByCep(cep);
    }

    @Transactional
    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }


    public Page<Endereco> findAll(Pageable paginacao){
        return repository.findAll(paginacao);
    }




}
