package com.mehmetsukrukavak.SpringJDBCEx;

import com.mehmetsukrukavak.SpringJDBCEx.model.Student;
import com.mehmetsukrukavak.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student student = context.getBean(Student.class);
		student.setRollNo(104);
		student.setName("John Doe");
		student.setMarks(95);

		StudentService studentService = context.getBean(StudentService.class);

		studentService.addStudent(student);

		List<Student> students = studentService.getStudents();

		System.out.println(students);

	}

}
