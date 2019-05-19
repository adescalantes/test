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
import com.trainee.services.IStudentService;
import com.trainee.services.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de la clase Student
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD Student")
public class StudentController {

  @Autowired
  private IStudentService studentService;

  /**
   * Método GET para obtener todos los objetos de la clase Students
   * 
   * @return Todos los objetos de la clase Students almacenados
   */
  @GetMapping(value = "/students")
  @ApiOperation("Return all Students")
  public List<Student> getAll() {
    return studentService.getAll();
  }

  /**
   * Método POST para guardar un objeto de la clase Student
   * 
   * @param student Ingresamos los datos del objeto Student que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @PostMapping(value = "/students")
  @ApiOperation("Create a new Student")
  public void postStudent(@RequestBody @Valid Student student) {
    studentService.post(student);
  }

  /**
   * Método PUT para actualizar un objeto de la clase Student
   * 
   * @param student Ingresamos los datos del objeto Student que deseamos
   *                actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @PutMapping(value = "/students")
  @ApiOperation("Update a Student")
  public void putStudent(@RequestBody @Valid Student student) {
    studentService.putById(student);
  }

  /**
   * Método DELETE para eliminar un objeto de la clase Student
   * 
   * @param id Id del objeto Student que deseamos eliminar
   */
  @DeleteMapping(value = "/students/{id}")
  @ApiOperation("Delete a Student")
  public void deleteStudent(@PathVariable("id") int studentId) {
    studentService.deleteById(studentId);
  }
}
