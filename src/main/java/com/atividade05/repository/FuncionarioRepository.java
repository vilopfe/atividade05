package com.atividade05.repository;

import com.atividade05.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    List<Funcionario> findByNomeFuncionario(String nomeFuncionario);
    List<Funcionario> findByQtdeDependentes(Integer qtdeDependentes);
    Funcionario findFirstBy();
}
