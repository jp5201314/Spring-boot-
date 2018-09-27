package com.spring.comtroller.demo.repository;

import com.spring.comtroller.demo.bean.Student;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student,Long> {

}
