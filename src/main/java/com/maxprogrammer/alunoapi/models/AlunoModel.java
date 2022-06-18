package com.maxprogrammer.alunoapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;

    @Deprecated
    public AlunoModel() {
    }

    public AlunoModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
