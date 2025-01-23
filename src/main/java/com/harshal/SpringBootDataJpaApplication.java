package com.harshal;


import java.util.Arrays;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.harshal.entity.Student;
import com.harshal.repository.StudentRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
		Student s1 = new Student(101, "Harshal", 90l, "Male");
		Student s2 = new Student(102, "Cathy", 100l, "FeMale");
		Student s3 = new Student(103, "Buttler", 70l, "Male");
		Student s4 = new Student(104, "Smitha", 60l, "FeMale");
		
		List<Student> students = Arrays.asList(s1, s2, s3, s4);
		
		  // studentRepository.saveAll(students);
		   
		    List<Student> allStudentsBySQL = studentRepository.getAllStudents();
		     allStudentsBySQL.forEach(System.out::println);
		     
		     List<Student> allStudentsByHQL = studentRepository.getStudents();
		     allStudentsByHQL.forEach(System.out::println);
		
		
       

		
        
        context.close();
	}

}
