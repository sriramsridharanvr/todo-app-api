package com.yethi.ngfms.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yethi.ngf.sys.repository.generic.GenericRepository;
import com.yethi.ngf.sys.service.generic.AbstractService;
import com.yethi.ngfms.todo.entity.Todo;

@Service
public class TodoService extends AbstractService<Todo>{
		
	private GenericRepository<Todo> todoRepository;
	
	@Autowired
	public void setTodoRepository(GenericRepository<Todo> todoRepository) {
		this.todoRepository = todoRepository;
		this.todoRepository.setTypeParameterClass(Todo.class);
	}
	
	@Override
	protected GenericRepository<Todo> getRepository() {
		return todoRepository;
	}
}
