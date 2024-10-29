package edu.kh.todoList.todo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todoList.todo.model.dao.TodoMapper;
import edu.kh.todoList.todo.model.dto.Todo;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoMapper mapper;
	
	// Todo 목록조회
	@Override
	public List<Todo> todoListAllView(int memberNo) {
		return mapper.todoListAllView(memberNo);
	}

	// Todo 삽입
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int todoInsert(Todo todo) {
		return mapper.todoInsert(todo);
	}

}
