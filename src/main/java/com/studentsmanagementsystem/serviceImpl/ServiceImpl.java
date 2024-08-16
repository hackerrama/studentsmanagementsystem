package com.studentsmanagementsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsmanagementsystem.entity.Student;
import com.studentsmanagementsystem.entity.User_Pass;
import com.studentsmanagementsystem.repository.Studentrepository;
import com.studentsmanagementsystem.repository.user_repo;
import com.studentsmanagementsystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService 
{
	@Autowired
	Studentrepository Studentrepository;

	public List<Student> getAllStudents() 
	{
		
		List<Student> list = Studentrepository.findAll();
		return list;
	}

	
	@Override
	public Student saveStudent(Student student)
	{
		return Studentrepository.save(student);
	}
	
	@Override
	public Student getById(int id)
	{
		
		return Studentrepository.findById(id).get();
	}
	
	@Override
	public void deleteById(int id)
	{
		Studentrepository.deleteById(id);
		
	}
		

}
