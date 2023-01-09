package com.attornatus.api.resources;

import com.attornatus.api.dto.EnderecoDTO;
import com.attornatus.api.entities.Endereco;
import com.attornatus.api.services.EnderecoService;
import com.attornatus.api.services.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/pessoas/endereco")
public class EnderecoResource {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;


    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarEndereco(@RequestBody @Valid EnderecoDTO dto, UriComponentsBuilder uriBuilder){
        Endereco endereco = dto.converterToEntity(pessoaService);
        enderecoService.save(endereco);

        URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
    }

    @GetMapping("/listar")
    public Page<EnderecoDTO> listarEnderecos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {

        Page<Endereco> endereco = enderecoService.findAll(paginacao);
        return EnderecoDTO.converterToDto(endereco);


    }

}
