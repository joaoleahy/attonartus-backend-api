package com.attornatus.api.Resources;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import com.attornatus.api.dto.PessoaDTO;
import com.attornatus.api.entities.Pessoa;
import com.attornatus.api.repositories.PessoaRepository;
import com.attornatus.api.resources.PessoaResource;
import com.attornatus.api.services.EnderecoService;
import com.attornatus.api.services.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest
public class PessoaResourceTests {

    @Autowired
    private PessoaResource pessoaResource;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository repository;

    @BeforeEach
    public void setup(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao Victor");
        pessoa.setDataNascimento("05/09/2001");
        repository.save(pessoa);
        standaloneSetup(this.pessoaResource);
    }

    @AfterEach
    public void down(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("Salva pessoa com sucesso")
    public void deveSalvarPessoa() throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Joao Victor");
        pessoaDTO.setDataNascimento("05/09/2001");



        String pessoaDto = mapper.writeValueAsString(pessoaDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/pessoas/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(pessoaDto)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deveRetornarOkQuandoBuscarPessoa(){

        Mockito.when(this.pessoaService.findById(1L)).thenReturn(Optional.of(new Pessoa(1L,"Joao Victor", "05/09/2001")));


        given()
                .accept(ContentType.JSON)
                .when()
                .get("api/pessoas/listar/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());


    }

}