package br.com.leandro.todolist.domain.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class AddTodoUnitTest {

	private TodoRepository todoRepository;

	private AddTodo addTodo;

	private TodoRequest todoRequest;

	@BeforeEach
	void setUp() {
		todoRepository = mock(TodoRepository.class);
		addTodo = new AddTodo(todoRepository);
		todoRequest = new TodoRequest("Learning Full Cycle course", "Study at least 2 hours a day", null);
	}

	@Test
	void shouldAddTodo_whenPassingValidData() {
		addTodo.execute(todoRequest.convert());
		verify(todoRepository).save(any(Todo.class));
	}

	@Test
	void shouldAddTodoWithStatusNotNull_whenPassingValidData() {
		todoRequest.setStatus("OPENED");
		addTodo.execute(todoRequest.convert());
		verify(todoRepository).save(any(Todo.class));
	}

}
