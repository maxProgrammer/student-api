package com.maxprogrammer.alunoapi.controller;

import com.maxprogrammer.alunoapi.dtos.AlunoDto;
import com.maxprogrammer.alunoapi.models.AlunoModel;
import com.maxprogrammer.alunoapi.services.CrudAlunoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CrudAlunosController {

    @Autowired
    CrudAlunoService crudAlunoService;

    @PostMapping(value = "/api/novo-aluno")
    @Operation(summary = "Add a student")
    @Transactional
    public void novoAluno(@RequestBody @Valid AlunoDto alunoDto) {
        AlunoModel novoAluno = alunoDto.novoAluno();
        crudAlunoService.save(novoAluno);
    }

    @PutMapping(value = "/api/aluno/{id}")
    @Operation(summary = "Update a student by id")
    public void atualizaAlunoPorId(@PathVariable("id") Long id, @RequestBody @Valid AlunoDto alunoDto) {
        Optional<AlunoModel> possivelAlunoModel = crudAlunoService.findById(id);
        AlunoModel alunoAtualizado = alunoDto.novoAluno();
        alunoAtualizado.setId(possivelAlunoModel.get().getId());
        crudAlunoService.save(alunoAtualizado);

    }

    @GetMapping(value = "/api/alunos")
    @Operation(summary = "return all students")
    public List<AlunoModel> retornaTodosAlunos() {

        return crudAlunoService.findAll();
    }

    @GetMapping(value = "/api/aluno/{id}")
    @Operation(summary = "return a student by Id")
    public Optional<AlunoModel> retornaAlunoPorId(@PathVariable("id") Long id) {
        return crudAlunoService.findById(id);
    }

    @Transactional
    @DeleteMapping(value = "/api/aluno/{id}")
    @Operation(summary = "delete a student by Id")
    public void deletaAlunoPorId(@PathVariable("id") Long id) {
        crudAlunoService.deleteById(id);
    }

}
