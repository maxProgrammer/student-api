package com.maxprogrammer.alunoapi.dtos;

import com.maxprogrammer.alunoapi.models.AlunoModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AlunoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    public AlunoModel novoAluno(){
        return new AlunoModel(nome,email);
    }
}
