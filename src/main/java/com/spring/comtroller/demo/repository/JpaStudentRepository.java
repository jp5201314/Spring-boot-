package com.spring.comtroller.demo.repository;

import com.spring.comtroller.demo.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRepository extends JpaRepository<Student,Long>{


}
