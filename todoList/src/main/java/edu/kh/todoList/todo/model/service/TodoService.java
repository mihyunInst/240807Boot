package edu.kh.todoList.todo.model.service;

import java.util.List;

import edu.kh.todoList.todo.model.dto.Todo;

public interface TodoService {

	/** Todo 목록 조회 서비스
	 * @param memberNo 
	 * @return todoList
	 */
	List<Todo> todoListAllView(int memberNo);

	/** Todo 삽입 서비스
	 * @param todo
	 * @return result
	 */
	int todoInsert(Todo todo);

}
