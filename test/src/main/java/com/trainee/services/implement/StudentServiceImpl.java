package com.trainee.services.implement;

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
import com.trainee.services.IStudentService;

/**
 * Clase donde se realizá la lógica de la clase Student para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements IStudentService {
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);
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
  public void post(Student student) {

    if (studentRepository.findById(student.getId()) == null) {
      log.info("A new Student was created");
      studentRepository.save(student);
    } else {
      log.debug("Can't create a new Student");
    }

  }

  /**
   * Método para actualizar un objeto de la clase Student
   * 
   * @param student Recibir un objeto Student para luego actualizar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public void putById(Student student) {
    if (studentRepository.findById(student.getId()) != null) {
      log.info("A new Student was updated");
      studentRepository.save(student);
    } else {
      log.debug("Can't update a new Student");
    }

  }

  /**
   * Método para eliminar un objeto de la clase Student por id
   * 
   * @param id Id de Student
   */
  public void deleteById(int studentId) { 
    Student student = studentRepository.findById(studentId);
    if (studentRepository.findById(studentId) != null) {
    	log.info("Student was deleted");
    	studentRepository.delete(student);
    } else {
    	log.info("Can't delete Student");
    }

  }
}
