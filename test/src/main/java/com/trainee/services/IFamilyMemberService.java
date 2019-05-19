package com.trainee.services;

import java.util.List;

import com.trainee.models.FamilyMember;

public interface IFamilyMemberService {
	
	public List<FamilyMember> getAll();
	
	public void post(FamilyMember familyMember);
	
	public void putById(FamilyMember familyMember);
	
	public void deleteById(int familyMemberId);
	
}
