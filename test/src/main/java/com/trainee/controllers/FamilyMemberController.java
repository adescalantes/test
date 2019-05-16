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

import com.trainee.models.FamilyMember;
import com.trainee.services.FamilyMemberService;

import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de FamilyMember
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")

public class FamilyMemberController {

  @Autowired
  private FamilyMemberService familyMemberService;

  /**
   * Método GET para obtener todos los FamilyMembers
   * 
   * @return Todos los FamilyMembers almacenados
   */
  @ApiOperation("Return all FamilyMembers")
  @GetMapping("/familyMembers")
  public List<FamilyMember> getAll() {
    return familyMemberService.getAll();
  }

  /**
   * Método POST para guardar un FamilyMember
   * 
   * @param familyMember Ingresamos los datos del FamilyMember que deseamos
   *                     agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new FamilyMember")
  @PostMapping("/familyMembers")
  public ResponseEntity<FamilyMember> postFamilyMember(@RequestBody @Valid FamilyMember familyMember) {
    return familyMemberService.postFamilyMember(familyMember);
  }

  /**
   * Método PUT para actualizar un FamilyMember
   * 
   * @param familyMember Ingresamos los datos del FamilyMember que deseamos
   *                     actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a FamilyMember")
  @PutMapping("/familyMembers")
  public ResponseEntity<FamilyMember> putFamilyMember(@RequestBody @Valid FamilyMember familyMember) {
    return familyMemberService.putFamilyMember(familyMember);
  }

  /**
   * Método DELETE para eliminar un FamilyMember
   * 
   * @param id Id del FamilyMember que deseamos eliminar
   */
  @ApiOperation("Delete a FamilyMember")
  @DeleteMapping(value = "/familyMembers/{id}")
  public void deleteParents(@PathVariable("id") int id) {
    familyMemberService.deleteFamilyMember(id);
  }

}
