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

import com.trainee.models.Family;
import com.trainee.models.FamilyMember;
import com.trainee.services.FamilyService;

import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de Family
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")

public class FamilyController {

  @Autowired
  private FamilyService familyService;

  /**
   * Método GET para obtener todas las Families
   * 
   * @return Todas las Families almacenadas
   */
  @ApiOperation("Return all Families")
  @GetMapping("/families")
  public ResponseEntity<List<Family>> getAll() {
    return familyService.getAll();
  }

  /**
   * Método GET para obtener todos los FamilyMembers por un FamilyId
   * 
   * @param id Id de Family que queremos obtener
   * @return FamilyMembers
   */
  @ApiOperation("Return all Families by FamilyId")
  @GetMapping("/families/members/{id}")
  public List<FamilyMember> getFamily(@PathVariable("id") int id) {
    return familyService.getFamilyMembers(id);
  }

  /**
   * Método POST para guardar un Family
   * 
   * @param family Ingresamos los datos del Family que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new Family")
  @PostMapping("/families")
  public ResponseEntity<Family> postFamily(@RequestBody @Valid Family family) {
    return familyService.postFamily(family);
  }

  /**
   * Método PUT para actualizar un Family
   * 
   * @param family Ingresamos los datos del Family que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a Family")
  @PutMapping("/families")
  public ResponseEntity<Family> putFamily(@RequestBody @Valid Family family) {
    return familyService.putFamily(family);
  }

  /**
   * Método DELETE para eliminar un Family
   * 
   * @param id Id del Family que deseamos eliminar
   */
  @ApiOperation("Delete a Family")
  @DeleteMapping(value = "/families/{id}")
  public void deleteFamily(@PathVariable("id") int id) {
    familyService.deleteFamily(id);
  }
}
