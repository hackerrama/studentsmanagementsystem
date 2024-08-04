package com.studentsmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentsmanagementsystem.entity.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student, Integer>
{
	

}
