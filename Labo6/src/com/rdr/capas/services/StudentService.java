package com.rdr.capas.services;

import java.util.List;

import com.rdr.capas.domain.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public void save(Student student);
	public void update(Student student);
	public void delete(Student student);
	public Student findOne(Integer id);
	
}
