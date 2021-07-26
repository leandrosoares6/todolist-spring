package br.com.leandro.todolist.domain.ports.inputs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IListTodosInput {

	Page<?> execute(Pageable pagination);

}
