package com.atividade05.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Entity
@Data
public class Funcionario extends AbstractPersistable<Long> {
    private String nomeFuncionario;
    private Integer qtdeDependentes;
    @ManyToOne
    private Departamento departamento;


}
