package com.trainee.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;
import com.trainee.services.IStudentService;
import com.trainee.services.implement.StudentServiceImpl;

@RunWith(SpringRunner.class)
class StudentControllerTest {

	@Mock
	StudentRepository studentRepository;
	
	@Mock
	IStudentService studentService;
	
	@InjectMocks
	StudentController studentController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	 public void setup(){

        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

    }
	
	@Test
	void testGetAll() throws Exception {
		Student student = new Student();
		student.setId(1);
		student.setFirstName("Mock");
		
		when(studentRepository.findAll()).thenReturn(Collections.singleton(student));
		studentRepository.save(student);
		mockMvc.perform(get("/v1/students")).andDo(print());
	}

	@Test
	void testPostStudent() {
		fail("Not yet implemented");
	}

	@Test
	void testPutStudent() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteStudent() {
		fail("Not yet implemented");
	}

}
