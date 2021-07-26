package br.com.leandro.todolist.adapters.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.leandro.todolist.adapters.persistance.repositories.mongodb.ISpringDataMongoTodoRepository;

@EnableMongoRepositories(basePackageClasses = ISpringDataMongoTodoRepository.class)
public class MongoDBConfiguration {

}
