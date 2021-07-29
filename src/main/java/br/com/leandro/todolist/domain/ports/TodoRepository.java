package br.com.leandro.todolist.domain.ports;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leandro.todolist.domain.entities.Todo;

public interface TodoRepository {

	public void save(Todo todo);

	public Optional<Todo> findById(String id);

	public Todo findByTitle(String title);

	public Todo findByDescription(String description);

	public Page<Todo> findAll(Pageable pagination, Map<String, String> filters);

	public void destroy(Todo todo);

}
