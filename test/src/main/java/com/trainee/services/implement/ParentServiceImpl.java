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
import com.trainee.services.IParentService;

/**
 * Clase donde se realizá la lógica de la clase Parent para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class ParentServiceImpl implements IParentService {

  @Autowired
  private ParentRepository parentRepository;
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);

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
  public void post(Parent parent) {

    if (parentRepository.findById(parent.getId()) == null) {
      log.info("A new Parent was created");
      parentRepository.save(parent);
    } else {
      log.debug("Can't create a new Parent");
    }

  }

  /**
   * Método para actualizar un objeto de la clase Parent
   * 
   * @param parent Recibir un objeto Parent para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public void putById(Parent parent) {
    if (parentRepository.findById(parent.getId()) != null) {
      log.info("Parent was updated");
      parentRepository.save(parent);
    } else {
      log.debug("Can't update Parent");

    }

  }

  /**
   * Método para eliminar un objeto de la clase Parent por id
   * 
   * @param id Id de Parent
   */
  public void deleteById(int parentId) {
    Parent parent = parentRepository.findById(parentId);
    if (parentRepository.findById(parentId) != null) {
      log.info("Parent was deleted");
      parentRepository.delete(parent);

    } else {
    	log.debug("Can't delete Parent");
    }

  }
}
