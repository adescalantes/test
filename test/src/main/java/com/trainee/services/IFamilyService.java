package com.trainee.services;

import java.util.List;

import com.trainee.models.Family;
import com.trainee.models.FamilyMember;

public interface IFamilyService {

	public List<Family> getAll();
	
	public List<FamilyMember> getFamilyMembers(int familyId);
	
	public void post(Family family);
	
	public void putById(Family family);
	
	public void deleteById(int familyId);
}
