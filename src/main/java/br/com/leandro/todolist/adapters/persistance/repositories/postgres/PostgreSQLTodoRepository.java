package br.com.leandro.todolist.adapters.persistance.repositories.postgres;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

@Component
public class PostgreSQLTodoRepository implements ITodoRepository {

	private final SpringDataPostgresTodoRepository todoRepository;

	@Autowired
	public PostgreSQLTodoRepository(final SpringDataPostgresTodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public void save(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public Optional<Todo> findById(String id) {
		return todoRepository.findById(id);
	}

	@Override
	public Todo findByTitle(String title) {
		return todoRepository.findByTitle(title);
	}

	@Override
	public Todo findByDescription(String description) {
		return todoRepository.findByDescription(description);
	}

	@Override
	public Page<Todo> findAll(Pageable pagination) {
		Page<Todo> pageTodos = todoRepository.findAll(pagination);
		return pageTodos;
	}

	@Override
	public void destroy(Todo todo) {
		todoRepository.delete(todo);
	}

}
