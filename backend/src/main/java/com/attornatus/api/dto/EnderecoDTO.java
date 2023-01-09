package com.attornatus.api.dto;

import com.attornatus.api.entities.Endereco;
import com.attornatus.api.entities.Pessoa;
import com.attornatus.api.services.PessoaService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Boolean principal;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Long pessoa_id;

    public EnderecoDTO(Endereco endereco) {
        this.principal = endereco.getPrincipal();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.pessoa_id = endereco.getPessoa().getId();
    }


    public Endereco converterToEntity(PessoaService pessoaService) {
        Pessoa pessoas = pessoaService.getId(pessoa_id);
        return new Endereco(principal, logradouro, cep, numero, cidade, pessoas);
    }

    public static Page<EnderecoDTO> converterToDto(Page<Endereco> enderecos) {
        return enderecos.map(EnderecoDTO::new);
    }
}
