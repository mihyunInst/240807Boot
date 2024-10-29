package edu.kh.todoList.todo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.todoList.todo.model.dto.Todo;

@Mapper
public interface TodoMapper {

	/** Todo 목록 조회
	 * @param memberNo
	 * @return todoList
	 */
	List<Todo> todoListAllView(int memberNo);

	/** Todo 삽입
	 * @param todo
	 * @return result
	 */
	int todoInsert(Todo todo);

}
