package br.com.leandro.todolist.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.enums.Status;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class UpdateTodoUnitTest {

	private TodoRepository todoRepository;

	private UpdateTodo updateTodo;

	private Todo todo;

	@BeforeEach
	void setUp() {
		todoRepository = mock(TodoRepository.class);
		updateTodo = new UpdateTodo(todoRepository);
		todo = new Todo("TEST", "TEST");
	}

	@Test
	void shouldUpdateTodo_whenPassingValidData() {
		TodoRequest todoRequest = new TodoRequest("Learning Full Cycle course", "Study at least 2 hours a day",
				Status.OPENED.toString());

		doReturn(Optional.of(todo)).when(todoRepository).findById(todo.getId().toString());

		updateTodo.execute(todo.getId().toString(), todoRequest.convert());

		verify(todoRepository).save(any(Todo.class));

	}

	@Test
	void shouldUpdateTodoAndSetCompletedDate_whenPassingValidDataAndStatusCompleted() {
		TodoRequest todoRequest = new TodoRequest("Learning Full Cycle course", "Study at least 2 hours a day",
				Status.COMPLETED.toString());

		doReturn(Optional.of(todo)).when(todoRepository).findById(todo.getId().toString());

		updateTodo.execute(todo.getId().toString(), todoRequest.convert());

		assertNotNull(todo.getCompletedAt());

		verify(todoRepository).save(any(Todo.class));

	}

	@Test
	void shouldNotUpdateTodo_whenTodoNotFound() {
		TodoRequest todoRequest = new TodoRequest("Learning Full Cycle course", "Study at least 2 hours a day",
				Status.OPENED.toString());

		Exception e = assertThrows(EntityNotFoundException.class,
				() -> updateTodo.execute("INVALID_UUID", todoRequest.convert()));
		assertEquals("Todo not found.", e.getMessage());

	}

}
