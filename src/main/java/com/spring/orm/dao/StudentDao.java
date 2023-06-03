package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
      private HibernateTemplate hibernateTemplate;
      
      // Save student
      @Transactional 
      public int insert(Student student)
      {
    	  Integer r = (Integer) this.hibernateTemplate.save(student);
    	  return r;
      }
      
      //get single data object
      public Student getStudent(int studentId)
      {
    	   Student student = this.hibernateTemplate.get(Student.class, studentId);
    	   return student;
      }
      //get all data object
      public List<Student> getAllStudent()
      {
    	  List<Student> student = this.hibernateTemplate.loadAll(Student.class);
    	  return student;
      }
      
      // Delete the data
      @Transactional
      public void deleteStudent(int studentId)
      {
    	  Student student = this.hibernateTemplate.get(Student.class, studentId);
    	  this.hibernateTemplate.delete(student);
      }
      
      //  Update data
      @Transactional
      public void updateStudent(Student student)
      {
    	  this.hibernateTemplate.update(student);
      }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
      
      
}
