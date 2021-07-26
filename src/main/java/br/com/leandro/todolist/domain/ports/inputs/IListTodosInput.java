package br.com.leandro.todolist.domain.ports.inputs;

import java.util.List;
import java.util.Optional;

public interface IListTodosInput {

	List<?> execute(Optional<Integer> page, Optional<Integer> size);

}
