package com.studentsmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentsmanagementsystem.entity.Student;
import com.studentsmanagementsystem.entity.User_Pass;
import com.studentsmanagementsystem.service.StudentService;
import com.studentsmanagementsystem.service.UserService;

@org.springframework.stereotype.Controller
public class Controller 
{

	@Autowired
	private StudentService service;
	
	@Autowired
	private UserService uservice;
	
	@GetMapping("/")
	public String home()
	{
		System.out.println("Controller.home()");
		return "home";
	}
	

	@GetMapping("/login")
	public String Student() {
		System.out.println("Controller.Student1()");

		return "login";
	}
	
	@PostMapping("/studentss")
	public String getAllStudents(@RequestParam("userid") String userid, @RequestParam("pass") String password, Model model)
	{
		for(User_Pass u : uservice.getAllUser())
		{
			if(userid.equals(u.getUser()) && password.equals(u.getPass()))
			{
				System.out.println("Controller.getAllStudents()");
				model.addAttribute("students", service.getAllStudents());
	
				return "students";
			}
			else
			{
				System.out.println("Controller.getAllStudents(1)");
				return "error";
			}
		}
		
		return "";
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {

		model.addAttribute("students", service.getAllStudents());
		return "students"; // View
	}

	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		Student student = new Student(); // To Hold The Student Object
		model.addAttribute("student", student);
		return "create-student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);

		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		System.out.println("Controller.editStudentForm()");
		model.addAttribute("student", service.getById(id));

		return "edit_student";

	}

	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		Student existingStudent = service.getById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setContact(student.getContact());
		existingStudent.setDob(student.getDob());
		existingStudent.setCourse(student.getCourse());
		service.saveStudent(existingStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
	}

}
