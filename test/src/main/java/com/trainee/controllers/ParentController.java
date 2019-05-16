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
import com.trainee.services.ParentService;
/**
 * Clase para manejar el RestController de Parent
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
   * Método GET para obtener todos los Parents
   * 
   * @return Todos los Parents almacenados
   */
  @GetMapping(value = "/parents")
  public List<Parent> getAll() {
    return parentService.getAll();
  }

  /**
   * Método POST para guardar un Parent
   * 
   * @param parent Ingresamos los datos del Parent que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @PostMapping(value = "/parents")
  public ResponseEntity<Parent> postParent(@RequestBody @Valid Parent parent) {
    return parentService.postParent(parent);
  }

  /**
   * Método PUT para actualizar un Parent
   * 
   * @param parent Ingresamos los datos del Parent que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @PutMapping(value = "/parents")
  public ResponseEntity<Parent> putParent(@RequestBody @Valid Parent parent) {
    return parentService.putParent(parent);
  }

  /**
   * Método DELETE para eliminar un Parent
   * @param id Id del Parent que deseamos eliminar
   */
  @DeleteMapping(value = "/parents/{id}")
  public void deleteParent(@PathVariable("id") int id) {
    parentService.deleteParent(id);
  }
}
