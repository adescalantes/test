package com.trainee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Family;
/**
 * Repositorio de Family para la consulta de datos
 * @author Alexander
 *
 */
import com.trainee.models.FamilyMember;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {
	
	public Family findById(int familyId);

}
