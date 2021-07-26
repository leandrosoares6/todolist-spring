package br.com.leandro.todolist.adapters.persistance.repositories.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

@Component
public class MongoDBTodoRepository implements ITodoRepository {

	private final ISpringDataMongoTodoRepository todoRepository;

	@Autowired
	public MongoDBTodoRepository(final ISpringDataMongoTodoRepository todoRepository) {
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
	public List<Todo> findAll(int page, int size) {
		PageRequest paging = PageRequest.of(page, size);
		Page<Todo> pageTodos = todoRepository.findAll(paging);
		return pageTodos.getContent();
	}

	@Override
	public void destroy(Todo todo) {
		todoRepository.delete(todo);
	}

}