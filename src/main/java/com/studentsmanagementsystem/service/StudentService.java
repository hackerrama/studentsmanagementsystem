package com.studentsmanagementsystem.service;

import java.util.List;

import com.studentsmanagementsystem.entity.Student;
import com.studentsmanagementsystem.entity.User_Pass;

public interface StudentService
{
	public List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student getById(int id);

	public void deleteById(int id);


}
