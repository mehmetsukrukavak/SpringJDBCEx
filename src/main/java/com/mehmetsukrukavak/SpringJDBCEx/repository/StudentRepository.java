package com.mehmetsukrukavak.SpringJDBCEx.repository;

import com.mehmetsukrukavak.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {


    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";

       int rows = jdbcTemplate.update(sql, student.getId(), student.getName(), student.getMarks());
        System.out.println(rows + " rows inserted");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        return jdbcTemplate.query(sql,  (rs,  rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });

    }
}
