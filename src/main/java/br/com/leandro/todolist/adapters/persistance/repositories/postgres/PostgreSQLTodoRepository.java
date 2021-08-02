package br.com.leandro.todolist.adapters.persistance.repositories.postgres;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.leandro.todolist.adapters.persistance.repositories.postgres.specifications.TodoSpecifications;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

@Component
public class PostgreSQLTodoRepository implements TodoRepository {

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
		try {
			UUID.fromString(id);
		}
		catch (IllegalArgumentException e) {
			throw new EntityNotFoundException();
		}

		return todoRepository.findById(UUID.fromString(id));
	}

	@Override
	public Page<Todo> findAll(Pageable pagination, Map<String, String> filters) {
		if (filters.get("title") == null && filters.get("description") == null) {
			return todoRepository.findAll(pagination);
		}

		return todoRepository.findAll(
				TodoSpecifications.likeTitleOrDescription(filters.get("title"), filters.get("description")),
				pagination);
	}

	@Override
	public void destroy(Todo todo) {
		todoRepository.delete(todo);
	}

}
