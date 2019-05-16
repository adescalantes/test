package com.trainee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Family;
import com.trainee.models.FamilyMember;
import com.trainee.repositories.FamilyMemberRepository;
import com.trainee.repositories.FamilyRepository;

/**
 * Clase donde se realizá la lógica de Family para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class FamilyService {
  private static final Logger log = LoggerFactory.getLogger(FamilyService.class);

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private FamilyMemberRepository familyMemberRepository;

  /**
   * Método para obtener todos las Families
   * 
   * @return Todos los FamilyMember
   */
  public List<Family> getAll() {
    log.info("Getting All Families");
    return familyRepository.findAll();
  }

  /**
   * Método para obtener todos los FamilyMembers por un FamilyId
   * 
   * @param id Recibir un familyId
   * @return Todos los FamilyMember por familyId
   */
  public List<FamilyMember> getFamilyMembers(int id) {
    log.info("Getting all familyMembers by familyId");
    return familyMemberRepository.findByFamilyId(id);
  }

  /**
   * Método para crear un Family
   * 
   * @param family Recibir un Family para luego guardar si se cumple la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Family> postFamily(Family family) {
    if (familyRepository.findById(family.getId()) == null) {
      log.debug("A new family was created");
      familyRepository.save(family);
      return new ResponseEntity<Family>(HttpStatus.CREATED);
    } else {
      log.debug("Can't create a new family");
      return new ResponseEntity<Family>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un Family
   * 
   * @param family Recibir un Family para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<Family> putFamily(Family family) {
    if (familyRepository.findById(family.getId()) != null) {
      log.debug("A new family was updated");
      familyRepository.save(family);
      return new ResponseEntity<Family>(HttpStatus.ACCEPTED);
    } else {
      log.debug("Can't update that family");
      return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un Family por id
   * 
   * @param id Id de Family
   */
  public void deleteFamily(int id) {
    log.debug("A family was deleted");
    Family family = familyRepository.findById(id);
    familyRepository.delete(family);

  }
}
