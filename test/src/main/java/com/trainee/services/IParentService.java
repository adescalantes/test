package com.trainee.services;

import java.util.List;

import com.trainee.models.Parent;

public interface IParentService {

	public List<Parent> getAll();
	
	public void post(Parent parent);
	
	public void putById(Parent parent);
	
	public void deleteById(int parentId);
}
