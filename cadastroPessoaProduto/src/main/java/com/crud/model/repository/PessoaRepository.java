package com.crud.model.repository;

import com.crud.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //para spring entende que e um repositorio
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
