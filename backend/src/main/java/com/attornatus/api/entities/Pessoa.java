package com.attornatus.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")
@Table(name = "tb_pessoa")
@Entity(name = "Pessoa")
public class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;

    private String nome;

    private String data_nascimento;

    @OneToMany(mappedBy = "pessoa")
    @JsonManagedReference
    private List<Endereco> endereco = new ArrayList<>();


    public Pessoa(String nome, String data_nascimento, List<Endereco> enderecos) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.endereco = enderecos;
    }


    public Pessoa(Long id, String nome, String data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }
}
