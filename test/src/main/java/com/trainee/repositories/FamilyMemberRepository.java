package com.trainee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.FamilyMember;

/**
 * Repositorio de FamilyMember para la consulta de datos
 * @author Alexander
 *
 */
@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {

  public List<FamilyMember> findByFamilyId(int id);
  public FamilyMember findById(int id);
}
