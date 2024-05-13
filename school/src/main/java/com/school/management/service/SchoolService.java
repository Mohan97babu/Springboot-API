package com.school.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dto.ResponseDTO;

import com.school.management.entity.School;

import com.school.management.repository.SchoolRepository;

@Service
public class SchoolService {
   
	@Autowired
	private SchoolRepository schoolrepository;
	
//	public List<ResponseDTO> retrieveSchool()
//	{
//		List<SchoolEntity> data = this.schoolrepository.findAll();
//		List<ResponseDTO> resList = new ArrayList<ResponseDTO>();
//		for(SchoolEntity school : data) {
//			ResponseDTO temp = new ResponseDTO();
//			temp.setId(school.getId());
//			temp.setName(school.getName());
//			resList.add(temp);
//		}
//		return resList;
//	}
	public List<School> retrieveSchool(){
		return this.schoolrepository.findAll();
	}
	
	public School addSchool(final School schoolentity)
	{
		return this.schoolrepository.save(schoolentity);
	}
	
	public String deleteSchool(Long id)
	{
		//long schoolId = Long.parseLong(id);
	   // this.schoolrepository.deleteById(schoolId);	
		this.schoolrepository.deleteById(id);
		return "Deleted Sucessfully";
	}
	
//	public String updateSchool(Long id,SchoolEntity school)
//	{
//		Optional<SchoolEntity> existingSchoolOptional = schoolrepository.findById(id);
//		SchoolEntity existingSchool = existingSchoolOptional.get();
//		
//		existingSchool.setName(school.getName());
//		existingSchool.setAddress_1(school.getAddress_1());
//		existingSchool.setAddress_2(school.getAddress_2());
//		schoolrepository.save(existingSchool);
//	    return "Edited Successfully";
//	}
	public String updateSchool(Long id, School school) {
	    Optional<School> existingSchoolOptional = schoolrepository.findById(id);
	    if (existingSchoolOptional.isPresent()) {
	    	School existingSchool = existingSchoolOptional.get();
	        existingSchool.setName(school.getName());
	        existingSchool.setAddress_1(school.getAddress_1());
	        existingSchool.setAddress_2(school.getAddress_2());
	        schoolrepository.save(existingSchool);
	        return "Edited Successfully";
	    } else {
	        return "School with ID " + id + " not found";
	    }
	}
}
