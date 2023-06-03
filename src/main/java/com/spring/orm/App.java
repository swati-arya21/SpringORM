package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;

import org.hibernate.jdbc.Expectations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student = new Student(225,"Swati Arya","UP");
//        int r = studentDao.insert(student);
//        System.out.println("Number of records inserted" +r);
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go)
        {
        	System.out.println("Enter 1 for add new Student");
        	System.out.println("Enter 2 for display all Student ");
        	System.out.println("Enter 3 for get detail of single student ");
        	System.out.println("Enter 4 for delete Students");
        	System.out.println("Enter 5 for update Student");
        	System.out.println("Enter 6 for exit");
        	
        	try {
        		
        		  int input = Integer.parseInt(bf.readLine());
        		
        		switch(input)
        		{
        			case 1:
        			{
        				// add a new Student 
        				System.out.println("Enter User Id");
        				int userId = Integer.parseInt(bf.readLine());
        				
        				System.out.println("Enter User Name");
        				String userName = bf.readLine();
        				
        				System.out.println("Enter User City");
        				String userCity = bf.readLine();
        				 
        				Student stud = new Student(userId,userName,userCity);
        				
        				int result = studentDao.insert(stud);
        				System.out.println(result +"Unique Id of  Student that  added");
        				       				
        				break;
        			}
        			case 2:
        			{
        				// get all student data
        				System.out.println("_____________________________________________");
        				List<Student> s = studentDao.getAllStudent();
        				for(Student i:s)
        				{
        					System.out.println("Student ID: " +i.getStudentId());
        					System.out.println("Student Name: " + i.getStudentName());
        					System.out.println("Student City: " + i.getStudentCity());
        					System.out.println();
        				}
        				System.out.println("_____________________________________________");
        				break;
        			}
        			case 3:
        			{
        				//get Single Student data
        				System.out.println("Enter User Id");
        			    int uId = Integer.parseInt(bf.readLine());
        			    Student stud1 = studentDao.getStudent(uId);
        			    System.out.println("Id = "+stud1.getStudentId());
        			    System.out.println("Name= "+stud1.getStudentName());
        			    System.out.println("City = "+ stud1.getStudentCity());
        				break;
        			}
        			case 4:
        			{
        				// Student Deleted 
        				System.out.println("Enter StudentId ");
        				int id = Integer.parseInt(bf.readLine());
        				studentDao.deleteStudent(id);
        				System.out.println("Student Deleted");
        				break;
        			}
        			case 5:
        			{
        				// Update 
        				System.out.println("Enter User Id");
        				int userId1 = Integer.parseInt(bf.readLine());
        				
        				System.out.println("Enter User Name");
        				String userName1 = bf.readLine();
        				
        				System.out.println("Enter User City");
        				String userCity1 = bf.readLine();
        				 
        				Student stud2 = new Student(userId1,userName1,userCity1);
        				studentDao.updateStudent(stud2);
        				
        			    System.out.println("Data Updated");
        				break;
        			}
        			case 6:
        			{
        				go=false;
        				break;
        			}
        		}
        		
        	}catch(Exception e) {
        		System.out.println("Invalid data please enter Valid number");
        		System.out.println(e.getMessage());
        	};
        	
        }
    }
}
