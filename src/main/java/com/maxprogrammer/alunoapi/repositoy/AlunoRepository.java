package com.maxprogrammer.alunoapi.repositoy;

import com.maxprogrammer.alunoapi.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel,Long> {
}
