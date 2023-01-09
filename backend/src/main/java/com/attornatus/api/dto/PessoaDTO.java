package com.attornatus.api.dto;

import com.attornatus.api.entities.Endereco;
import com.attornatus.api.entities.Pessoa;
import com.attornatus.api.services.EnderecoService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private String nome;

    private String dataNascimento;

    @JsonIgnore
    private String cep;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();

    }

    public static Page<PessoaDTO> converterToDto(Page<Pessoa> pessoas) {
        return pessoas.map(PessoaDTO::new);
    }

    public Pessoa converterToEntity(EnderecoService enderecoService) {
        List<Endereco> enderecos = enderecoService.findByCep(cep);
        return new Pessoa(nome, dataNascimento, enderecos);
    }

}
