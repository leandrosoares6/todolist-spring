package br.com.leandro.todolist.domain.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.ports.outputs.AddTodoOutput;

public class AddTodoUnitTest {

	private TodoRepository todoRepository;

	private AddTodo addTodo;

	@BeforeEach
	void setUp() {
		todoRepository = mock(TodoRepository.class);
		AddTodoOutput viewModel = mock(AddTodoOutput.class);
		addTodo = new AddTodo(todoRepository, viewModel);
	}

	@Test
	void shouldAddTodo_whenPassingValidData() {
		TodoRequest todo = new TodoRequest("Learning Full Cycle course", "Study at least 2 hours a day");
		addTodo.execute(TodoRequest.convertToTodoData(todo));
		verify(todoRepository).save(any(Todo.class));
	}

}
