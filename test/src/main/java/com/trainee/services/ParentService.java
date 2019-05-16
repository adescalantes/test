package com.trainee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

/**
 * Clase donde se realizá la lógica de Parent para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class ParentService {

  @Autowired
  private ParentRepository parentRepository;

  /**
   * Método para obtener todos los Parents
   * 
   * @return Todos los Parents
   */
  
  
  public List<Parent> getAll() {
    return parentRepository.findAll();
  }

  /**
   * Método para crear un Parent
   * 
   * @param parent Recibir un Parent para luego guardar si se cumple la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Parent> postParent(Parent parent) {
	  
    if (parentRepository.findById(parent.getId()) == null) {
      parentRepository.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Parent>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un Parent
   * 
   * @param parent Recibir un Parent para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Parent> putParent(Parent parent) {
    if (parentRepository.findById(parent.getId()) != null) {
      parentRepository.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un Parent por id
   * 
   * @param id Id de Parent
   */
  public void deleteParent(int id) {
    Parent parent = parentRepository.findById(id);
    parentRepository.delete(parent);

  }
}
