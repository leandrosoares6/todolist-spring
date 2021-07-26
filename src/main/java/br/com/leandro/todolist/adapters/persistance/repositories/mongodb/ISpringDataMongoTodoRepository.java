package br.com.leandro.todolist.adapters.persistance.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leandro.todolist.domain.entities.Todo;

@Repository
public interface ISpringDataMongoTodoRepository extends MongoRepository<Todo, String> {

	public Todo findByTitle(String title);

	public Todo findByDescription(String description);

}
