package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;

/**
 * Clase donde se realizá la lógica de Student para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  /**
   * Método para obtener todos los Students
   * 
   * @return Todos los Students
   */
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  /**
   * Método para guardar un Student
   * 
   * @param student Recibir un Student para luego guardar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Student> postStudent(Student student) {
    if (studentRepository.findById(student.getId()) == null) {
      studentRepository.save(student);
      return new ResponseEntity<Student>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un Student
   * 
   * @param student Recibir un Student para luego actualizar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Student> putStudent(Student student) {
    if (studentRepository.findById(student.getId()) != null) {
      studentRepository.save(student);
      return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un Student por id
   * 
   * @param id Id de Student
   */
  public void deleteStudent(int id) {
    Student student = studentRepository.findById(id);
    studentRepository.delete(student);

  }
}
