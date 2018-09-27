package com.spring.comtroller.demo.service;

import com.spring.comtroller.demo.bean.Student;
import com.spring.comtroller.demo.repository.JpaStudentRepository;
import com.spring.comtroller.demo.result.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements IStudent {
    @Autowired
    JpaStudentRepository jpaStudentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = jpaStudentRepository.findAll();
        System.out.println(students.toString());
        return students;
    }

    @Override
    public int addStudent(Student student) {
        if (jpaStudentRepository.existsById(student.getId())){
            System.out.println("user  is existed");
            return ErrorCode.EXISTUSER;
        }
        Student saveStudent = jpaStudentRepository.save(student);
        if (saveStudent != null && saveStudent.getId() == student.getId()) {
            System.out.println("save success");
            return ErrorCode.ADDSUCCESS;
        } else {
            System.out.println("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int deleteStudent(long id) {
        if (jpaStudentRepository.existsById(id)) {
            jpaStudentRepository.deleteById(id);
            System.out.println("删除成功");
            return ErrorCode.DELETESUCCESS;
        }
        System.out.println("删除失败");
        return ErrorCode.NOTEXISTUSER;
    }

    @Override
    public int updateStudent(Student student) {
        if (jpaStudentRepository.existsById(student.getId())){
            jpaStudentRepository.save(student);
            System.out.println("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }
        System.out.println("更新失败");
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public Student queryStudent(long id) {
        Student student = null;
        if (jpaStudentRepository.existsById(id)){
            student = jpaStudentRepository.findById(id).get();
            System.out.println(student.toString());
        }
        return student;
    }
}
