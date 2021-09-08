package com.atividade05;

import java.util.Optional;

import com.atividade05.entity.Funcionario;
import com.atividade05.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atividade05.entity.Departamento;
import com.atividade05.service.DepartamentoService;

@SpringBootApplication
public class Atividade05Application {
	
	private static final Logger log = LoggerFactory.getLogger(Atividade05Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Atividade05Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService, FuncionarioService funcionarioService) {
		return (args) -> {
			Departamento dep1 = new Departamento();
			dep1.setNomeDepartamento("TI");
			Departamento dep2 = new Departamento();
			dep2.setNomeDepartamento("Financeiro");

			departamentoService.salvar(dep1);
			departamentoService.salvar(dep2);
			
			// retornando todos os departamentos
			log.info("Departamentos encontrados com findAll():");
			log.info("-------------------------------");
			for (Departamento departamento : departamentoService.buscarTodos()) {
				log.info(departamento.toString());
			}
			log.info("");

			//retornando dept por nome
			log.info("Departamentos encontrados com byNomeDepartamento(TI):");
			log.info("-------------------------------");
			for (Departamento departamento : departamentoService.buscarPorNome("TI")){
				log.info(departamento.toString());
			}
			
			// retornando um endereço pelo ID
			Optional<Departamento> departamento = departamentoService.buscaPorId(1L);
			log.info("Departamento encontrado com findById(1L):");
			log.info("--------------------------------");
			log.info(departamento.toString());
			log.info("");

			Funcionario fun1 = new Funcionario();
			fun1.setNomeFuncionario("vinicius");
			fun1.setQtdeDependentes(0);
			Funcionario fun2 = new Funcionario();
			fun2.setNomeFuncionario("fernandez");
			fun2.setQtdeDependentes(2);

			funcionarioService.salvar(fun1);
			funcionarioService.salvar(fun2);

			//retornando funcionario by all
			log.info("Funcionarios encontrados com findAll():");
			log.info("-------------------------------");
			for (Funcionario funcionario : funcionarioService.buscarTodos()) {
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario by name
			log.info("Funcionarios encontrados by name vinicius");
			log.info("--------------------------------");
			for(Funcionario funcionario : funcionarioService.buscarPorNome("vinicius")){
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario by dependentes
			log.info("Funcionarios encontrados by dependentes =1");
			log.info("---------------------------------");
			for (Funcionario funcionario : funcionarioService.buscarPorQtdeDependentes(1)){
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario por ID
			Optional<Funcionario> funcionario = funcionarioService.buscaPorId(1L);
			log.info("Funcionario encontrado com findById(1L):");
			log.info("--------------------------------");
			log.info(funcionario.toString());
			log.info("");

		};
	}
}
