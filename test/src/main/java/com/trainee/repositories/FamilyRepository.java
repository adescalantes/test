package com.trainee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Family;
/**
 * Repositorio de Family para la consulta de datos
 * @author Alexander
 *
 */
@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

  public Family findById(int id);

}
