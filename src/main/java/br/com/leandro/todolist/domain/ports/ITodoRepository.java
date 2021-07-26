package br.com.leandro.todolist.domain.ports;

import java.util.List;
import java.util.Optional;

import br.com.leandro.todolist.domain.entities.Todo;

public interface ITodoRepository {

	public void save(Todo todo);

	public Optional<Todo> findById(String id);

	public Todo findByTitle(String title);

	public Todo findByDescription(String description);

	public List<Todo> findAll(int page, int size);

	public void destroy(Todo todo);

}
