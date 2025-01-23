package com.harshal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.harshal.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	//SQL
	@Query(value = "select * from student_dtls", nativeQuery = true)
	public List<Student> getAllStudents();
	
	
	//HQL
	@Query("from Student")
	public List<Student> getStudents();
		

	/* 
	 *  SQL :   select * from student_dtls where student_gender=:gender	
		HQL :   from Student where gender=:gender

		SQl :  select * from student_dtls where student_gender is null	
		HQL : from Student where gender is null

		SQL : select * from student_dtls where student_rank >= : rank	
		HQL : from Student where rank >= :rank

		SQL :  select * from student_dtls where student_rank <= : rank
		HQL : from Student where rank <= :rank
	
		SQL :  select * from student_dtls where student_gender=:gender and student_rank >= :rank
		HQL : from Student where gender = :gender and rank >= :rank

		SQL : select  student_rank, student_gender from student_dtls
		HQL : select rank, gender from Student

	 */


}
