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

import com.trainee.models.Parent;
import com.trainee.models.Student;
import com.trainee.services.ParentService;

import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de la clase Parent
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")

public class ParentController {

  @Autowired
  private ParentService parentService;

  /**
   * Método GET para obtener todos los objetos de la clase Parents
   * 
   * @return Todos los objetos de la clase Parents almacenados
   */
  @ApiOperation("Return all Parents")
  @GetMapping(value = "/parents")
  public List<Parent> getAll() {
    return parentService.getAll();
  }

  /**
   * Método POST para guardar un objeto de la clase Parent
   * 
   * @param parent Ingresamos los datos del Parent que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new Parent")
  @PostMapping(value = "/parents")
  public ResponseEntity<Parent> postParent(@RequestBody @Valid Parent parent) {
    return parentService.postParent(parent);
  }

  /**
   * Método PUT para actualizar un objeto de la clase Parent
   * 
   * @param parent Ingresamos los datos del objeto Parent que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a Parent")
  @PutMapping(value = "/parents")
  public ResponseEntity<Parent> putParent(@RequestBody @Valid Parent parent) {
    return parentService.putParent(parent);
  }

  /**
   * Método DELETE para eliminar un objeto de la clase Parent
   * 
   * @param id Id del Parent que deseamos eliminar
   */
  @ApiOperation("Delete a Parent")
  @DeleteMapping(value = "/parents/{id}")
  public ResponseEntity<Parent> deleteParent(@PathVariable("id") int id) {
    return parentService.deleteParent(id);
  }
}
