package br.com.leandro.todolist.adapters.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.leandro.todolist.adapters.persistance.repositories.postgres.SpringDataPostgresTodoRepository;

@EnableJpaRepositories(basePackageClasses = SpringDataPostgresTodoRepository.class)
public class PostgreSQLConfiguration {

}
