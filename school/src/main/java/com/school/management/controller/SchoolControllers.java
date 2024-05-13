package com.school.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.dto.ResponseDTO;
import com.school.management.entity.School;
import com.school.management.service.SchoolService;



@RestController
@RequestMapping("/api/v1")
public class SchoolControllers {
   
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/school")
//	public List<ResponseDTO> retrieveSchool()
//	{
//		return this.schoolService.retrieveSchool();
//	}
	public List<School> retrieveSchool()
	{
		return this.schoolService.retrieveSchool();
	}
	
	@PostMapping("/add-school")
	public School addSchool(@RequestBody School Schoolentity)
	{
		return this.schoolService.addSchool(Schoolentity);
	   	
	}
	
	@DeleteMapping("/{id}")
	public String deleteSchool(@PathVariable("id")Long id)
	{
		return this.schoolService.deleteSchool(id);
	}
	
	@PutMapping("/{id}")
	public String updateSchool(@PathVariable("id")Long id,@RequestBody School School)
	{
		return this.schoolService.updateSchool(id,School);
	}
}
