package com.spring.comtroller.demo.service;

import com.spring.comtroller.demo.bean.Student;

import java.util.List;

public interface IStudent {
    //获取所有的学生
    List<Student> getAllStudent();
    //增
    int  addStudent(Student student);
    //删
    int  deleteStudent(long id);
    //改
    int updateStudent(Student student);
    //查
    Student queryStudent(long id);
}
