package com.rdr.capas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rdr.capas.domain.Student;
import com.rdr.capas.services.StudentService;


@Controller
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView initMain() {		
		ModelAndView mav = new ModelAndView();	
		List<Student> estudiantes = studentService.findAll();
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}	
	
	@RequestMapping("/edit")
	public ModelAndView editStudent(@RequestParam String id) {		
		ModelAndView mav = new ModelAndView();	
		System.out.println("El ID es: " + id);
		Student estudiante = studentService.findOne(Integer.parseInt(id));
		mav.addObject("estudiante", estudiante);
		mav.setViewName("student-info");
		return mav;
	}	
	
	@RequestMapping("/edit-student")
	public ModelAndView editStudentInfo(@ModelAttribute Student student) {		
		ModelAndView mav = new ModelAndView();	
				
		studentService.update(student);
		
		List<Student> estudiantes = studentService.findAll();
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}	
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam String id) {		
		ModelAndView mav = new ModelAndView();	
		System.out.println("El ID es: " + id);
		Student estudiante = studentService.findOne(Integer.parseInt(id));
		mav.addObject("estudiante", estudiante);
		mav.setViewName("student-delete");
		return mav;
	}	
	
	@RequestMapping("/delete-student")
	public ModelAndView deleteStudent(@ModelAttribute Student student) {		
		ModelAndView mav = new ModelAndView();	
				
		studentService.delete(student);
		
		List<Student> estudiantes = studentService.findAll();
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}	
	
	@RequestMapping("/create-student")
	public ModelAndView createStudent() {		
		ModelAndView mav = new ModelAndView();	
		
		Student estudiante = new Student();
		
		mav.addObject("estudiante", estudiante);
		mav.setViewName("student-create");
		return mav;
	}	
	
	@RequestMapping("/create")
	public ModelAndView create(@ModelAttribute Student student) {		
		ModelAndView mav = new ModelAndView();	
				
		studentService.save(student);
		
		List<Student> estudiantes = studentService.findAll();
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}	
	
	
	
	
}
