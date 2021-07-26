package br.com.leandro.todolist.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.DomainException;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

public class FindTodoByTitleUnitTest {

	private Todo anyTodo;

	private ITodoRepository todoRepository;

	private FindTodoByTitle findTodoByName;

	@BeforeEach
	void setUp() {
		anyTodo = new Todo("Do physical activity", "30 minutes on three days a week");
		todoRepository = mock(ITodoRepository.class);
		findTodoByName = new FindTodoByTitle(todoRepository);
	}

	@Test
	void shouldGetTodo_whenSearchedTodoExists() {
		String name = "Do physical activity";
		when(todoRepository.findByTitle(name)).thenReturn(anyTodo);
		Todo result = findTodoByName.execute(name);
		assertEquals(anyTodo, result);
	}

	@Test
	void shouldThrowException_whenSearchedTodoNotExists() {
		assertThrows(EntityNotFoundException.class, () -> {
			findTodoByName.execute("INVALID_TODO");
		});
	}

	@Test
	void shouldThrowException_whenPassingInvalidName() {
		assertThrows(DomainException.class, () -> {
			findTodoByName.execute("INVALID_TITLE");
		});
	}

}
