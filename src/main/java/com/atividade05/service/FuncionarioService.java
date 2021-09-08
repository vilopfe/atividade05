package com.atividade05.service;

import com.atividade05.entity.Funcionario;
import com.atividade05.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository ;

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscaPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> buscarPorNome(String nomeFuncionario) {return funcionarioRepository.findByNomeFuncionario(nomeFuncionario); }

    public List<Funcionario> buscarPorQtdeDependentes(Integer qtdeDependentes) {return funcionarioRepository.findByQtdeDependentes(qtdeDependentes); }

}

