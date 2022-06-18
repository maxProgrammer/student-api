package com.maxprogrammer.alunoapi.services;

import com.maxprogrammer.alunoapi.models.AlunoModel;
import com.maxprogrammer.alunoapi.repositoy.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CrudAlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Transactional
    public void save(AlunoModel alunoModel) {

        alunoRepository.save(alunoModel);
    }


    public List<AlunoModel> findAll() {

        return alunoRepository.findAll();
    }

    public Optional<AlunoModel> findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
