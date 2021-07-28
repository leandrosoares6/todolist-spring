package br.com.leandro.todolist.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class RemoveTodoUnitTest {

	private static final String INVALID_ID = "";

	private Todo anyTodo;

	private TodoRepository todoRepository;

	private RemoveTodo removeTodo;

	@BeforeEach
	void setUp() {
		anyTodo = new Todo("Do physical activity", "30 minutes on three days a week");
		todoRepository = mock(TodoRepository.class);
		removeTodo = new RemoveTodo(todoRepository);
	}

	@Test
	void shouldRemoveTodo_whenTodoExists() {
		doReturn(Optional.of(anyTodo)).when(todoRepository).findById(anyTodo.getId().toString());
		removeTodo.execute(anyTodo.getId().toString());
		verify(todoRepository).destroy(anyTodo);
	}

	@Test
	void shouldThrowException_whenSearchedTodoNotExists() {
		assertThrows(EntityNotFoundException.class, () -> {
			removeTodo.execute(INVALID_ID);
		});
	}

}
