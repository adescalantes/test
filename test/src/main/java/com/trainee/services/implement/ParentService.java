package com.trainee.services.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

/**
 * Clase donde se realizá la lógica de la clase Parent para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class ParentService {

  @Autowired
  private ParentRepository parentRepository;
  private static final Logger log = LoggerFactory.getLogger(FamilyService.class);

  /**
   * Método para obtener todos los objetos de la clase Parents
   * 
   * @return Todos los Parents
   */

  public List<Parent> getAll() {
    log.info("Getting All Parents");
    return parentRepository.findAll();
  }

  /**
   * Método para crear un objeto de la clase Parent
   * 
   * @param parent Recibir un objeto Parent para luego guardar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Parent> postParent(Parent parent) {

    if (parentRepository.findById(parent.getId()) == null) {
      log.info("A new Parent was created");
      parentRepository.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.CREATED);
    } else {
      log.debug("Can't create a new Parent");
      return new ResponseEntity<Parent>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un objeto de la clase Parent
   * 
   * @param parent Recibir un objeto Parent para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Parent> putParent(Parent parent) {
    if (parentRepository.findById(parent.getId()) != null) {
      log.info("Parent was updated");
      parentRepository.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.ACCEPTED);
    } else {
      log.debug("Can't update Parent");
      return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un objeto de la clase Parent por id
   * 
   * @param id Id de Parent
   */
  public ResponseEntity<Parent> deleteParent(int id) {
    Parent parent = parentRepository.findById(id);
    if (parentRepository.findById(id) != null) {
      log.info("Parent was deleted");
      parentRepository.delete(parent);
      return new ResponseEntity<Parent>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
    }

  }
}
