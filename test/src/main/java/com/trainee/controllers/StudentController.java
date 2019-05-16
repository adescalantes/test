package com.trainee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.models.Student;
import com.trainee.services.StudentService;
/**
 * Clase para manejar el RestController de Student
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
public class StudentController {

  @Autowired
  private StudentService studentService;

  /**
   * Método GET para obtener todos los Students
   * 
   * @return Todos los Students almacenados
   */
  @GetMapping(value = "/students")
  public List<Student> getAll() {
    return studentService.getAll();
  }

  /**
   * Método POST para guardar un Student
   * 
   * @param student Ingresamos los datos del Student que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @PostMapping(value = "/students")
  public ResponseEntity<Student> postStudent(@RequestBody @Valid Student student) {
    return studentService.postStudent(student);
  }

  /**
   * Método PUT para actualizar un Student
   * 
   * @param student Ingresamos los datos del Student que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @PutMapping(value = "/students")
  public ResponseEntity<Student> putStudent(@RequestBody @Valid Student student) {
    return studentService.putStudent(student);
  }

  /**
   * Método DELETE para eliminar un Student
   * @param id Id del Student que deseamos eliminar
   */
  @DeleteMapping(value = "/students/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }
}
