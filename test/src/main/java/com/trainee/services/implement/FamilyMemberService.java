package com.trainee.services.implement;

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

/**
 * Clase donde se realizá la lógica de la clase FamilyMember para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class FamilyMemberService {

  @Autowired
  private FamilyMemberRepository familyMemberRepository;
  private static final Logger log = LoggerFactory.getLogger(FamilyService.class);

  /**
   * Método para obtener todos los objetos de la clase FamilyMembers
   * 
   * @return Todos los objetos de la clase FamilyMember
   */
  public List<FamilyMember> getAll() {
    log.info("Getting All FamilyMembers");
    return familyMemberRepository.findAll();
  }

  /**
   * Método para crear un objeto de la clase FamilyMember
   * 
   * @param familyMember Recibir un objeto FamilyMember para luego guardar si se cumple
   *                     la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<FamilyMember> postFamilyMember(FamilyMember familyMember) {
    if (familyMemberRepository.findById(familyMember.getId()) == null) {
      log.info("A new FamilyMember was created");
      familyMemberRepository.save(familyMember);
      return new ResponseEntity<FamilyMember>(HttpStatus.CREATED);
    } else {
      log.debug("Can't create a new FamilyMember");
      return new ResponseEntity<FamilyMember>(HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Método para actualizar un objeto de la clase FamilyMember
   * 
   * @param familyMember Recibir un objeto FamilyMember para luego actualizar si se
   *                     cumple la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public ResponseEntity<FamilyMember> putFamilyMember(FamilyMember familyMember) {
    if (familyMemberRepository.findById(familyMember.getId()) != null) {
      log.info("FamilyMember was updated");
      familyMemberRepository.save(familyMember);
      return new ResponseEntity<FamilyMember>(HttpStatus.ACCEPTED);
    } else {
      log.debug("Can't update FamilyMember");
      return new ResponseEntity<FamilyMember>(HttpStatus.NOT_FOUND);
    }

  }

  /**
   * Método para eliminar un objeto de la clase FamilyMember por id
   * 
   * @param id Id de FamilyMember
   */
  public ResponseEntity<FamilyMember> deleteFamilyMember(int id) {   
    FamilyMember familyMember = familyMemberRepository.findById(id);
    if (familyMemberRepository.findById(id) != null) {
    	log.info("FamilyMember was deleted");
      familyMemberRepository.delete(familyMember);
      return new ResponseEntity<FamilyMember>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<FamilyMember>(HttpStatus.NOT_FOUND);
    }
  }
}
