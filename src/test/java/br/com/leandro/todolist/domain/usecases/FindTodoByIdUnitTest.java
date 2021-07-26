package br.com.leandro.todolist.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

public class FindTodoByIdUnitTest {

	private static final String INVALID_ID = "";

	private Todo anyTodo;

	private ITodoRepository todoRepository;

	private FindTodoById findTodoById;

	@BeforeEach
	void setUp() {
		anyTodo = new Todo("Do physical activity", "30 minutes on three days a week");
		todoRepository = mock(ITodoRepository.class);
		findTodoById = new FindTodoById(todoRepository);
	}

	@Test
	void shouldGetTodo_whenSearchedTodoExists() {
		when(todoRepository.findById(anyTodo.getId())).thenReturn(Optional.of(anyTodo));
		Todo result = findTodoById.execute(anyTodo.getId());
		assertEquals(result, anyTodo);
	}

	@Test
	void shouldThrowException_whenSearchedTodoNotExists() {
		assertThrows(EntityNotFoundException.class, () -> {
			findTodoById.execute(INVALID_ID);
		});
	}

}
