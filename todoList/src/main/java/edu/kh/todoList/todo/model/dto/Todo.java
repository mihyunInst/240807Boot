package edu.kh.todoList.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Todo {
	private int rowNum; // 가상번호 (사용자에게 보여지는 가짜 순번)
	private int todoNo;
	private int memberNo;
	private String todoTitle;
	private String todoContent;
	private String regDate;
	private char status;
}
