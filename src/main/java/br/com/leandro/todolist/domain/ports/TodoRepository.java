package br.com.leandro.todolist.domain.ports;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leandro.todolist.domain.entities.Todo;

public interface TodoRepository {

	public void save(Todo todo);

	public Optional<Todo> findById(UUID id);

	public Todo findByTitle(String title);

	public Todo findByDescription(String description);

	public Page<Todo> findAll(Pageable pagination);

	public void destroy(Todo todo);

}
