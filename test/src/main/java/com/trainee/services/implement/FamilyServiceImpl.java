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
import com.trainee.repositories.FamilyRepository;
import com.trainee.services.IFamilyService;

/**
 * Clase donde se realizá la lógica de la clase Family para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class FamilyServiceImpl implements IFamilyService {
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private FamilyMemberRepository familyMemberRepository;

  /**
   * Método para obtener todos los objetos de la clase Family
   * 
   * @return Todos los objetos de la clase FamilyMember
   */
  public List<Family> getAll() {
    log.info("Getting All Families");
    return familyRepository.findAll();
  }

  /**
   * Método para obtener todos los objetos de la clase FamilyMembers por un
   * FamilyId
   * 
   * @param id Recibir un familyId de la clase Family
   * @return Todos los objetos de la clase FamilyMember por familyId
   */
  public List<FamilyMember> getFamilyMembers(int familyId) {
    log.info("Getting all familyMembers by familyId");
    return familyMemberRepository.findByFamilyId(familyId);
  }

  /**
   * Método para crear un objeto de la clase Family
   * 
   * @param family Recibir un objeto Family para luego guardar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public void post(Family family) {
    if (familyRepository.findById(family.getId()) == null) {
      log.info("A new family was created");
      familyRepository.save(family);
    } else {
      log.debug("Can't create a new family");
    }

  }

  /**
   * Método para actualizar un objeto de la clase Family
   * 
   * @param family Recibir un objeto Family para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  public void putById(Family family) {
    if (familyRepository.findById(family.getId()) != null) {
      log.info("Family was updated");
      familyRepository.save(family);
    } else {
      log.debug("Can't update that family");
    }

  }

  /**
   * Método para eliminar un objeto de la clase Family por id
   * 
   * @param id Id de Family
   */
  public void deleteById(int familyId) {
    Family family = familyRepository.findById(familyId);
    if (familyRepository.findById(familyId) != null) {
      log.info("A family was deleted");
      familyRepository.delete(family);
    } else {
      log.info("Can't delete Family");
    }

  }
}
