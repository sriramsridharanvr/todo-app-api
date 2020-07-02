package com.yethi.ngfms.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yethi.ngfms.todo.entity.Todo;
import com.yethi.ngfms.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos() {
		return ResponseEntity.ok().body(todoService.getList());
	}
	
	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.ok().body(todoService.add(todo));
	}
	
	@PutMapping("/{todoId}")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable("todoId") Long id) {
		todo.setId(id);
		return ResponseEntity.ok().body(todoService.update(todo));
	}
	
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Todo> deleteTodo(@PathVariable("todoId") Long id) {
		todoService.remove(id);
		return ResponseEntity.ok().build();
	}
}
