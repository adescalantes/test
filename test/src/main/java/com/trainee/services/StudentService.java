package com.trainee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;

/**
 * Clase donde se realizá la lógica de la clase Student para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class StudentService {
  private static final Logger log = LoggerFactory.getLogger(FamilyService.class);
  @Autowired
  private StudentRepository studentRepository;

  /**
   * Método para obtener todos los objetos de la clase Students
   * 
   * @return Todos los objetos de la clase Students
   */
  public List<Student> getAll() {
    log.info("Getting All Students");
    return studentRepository.findAll();
  }

  /**
   * Método para crear un objeto de la clase Student
   * 
   * @param student Recibir un objeto Student para luego guardar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Student> postStudent(Student student) {

    if (studentRepository.findById(student.getId()) == null) {
      log.info("A new Student was created");
      studentRepository.save(student);
      return new ResponseEntity<Student>(HttpStatus.CREATED);
    } else {
      log.debug("Can't create a new Student");
      return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un objeto de la clase Student
   * 
   * @param student Recibir un objeto Student para luego actualizar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Student> putStudent(Student student) {
    if (studentRepository.findById(student.getId()) != null) {
      log.info("A new Student was updated");
      studentRepository.save(student);
      return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
    } else {
      log.debug("Can't update a new Student");
      return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un objeto de la clase Student por id
   * 
   * @param id Id de Student
   */
  public ResponseEntity<Student> deleteStudent(int id) { 
    Student student = studentRepository.findById(id);
    if (studentRepository.findById(id) != null) {
    	log.info("Student was deleted");
    	studentRepository.delete(student);
      return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

  }
}
