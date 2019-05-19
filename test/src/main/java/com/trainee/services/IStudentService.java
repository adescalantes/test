package com.trainee.services;

import java.util.List;

import com.trainee.models.Student;

public interface IStudentService {
	
	public List<Student> getAll();
	
	public void post(Student student);
	
	public void putById(Student student);
	
	public void deleteById(int studentId);
	
}
