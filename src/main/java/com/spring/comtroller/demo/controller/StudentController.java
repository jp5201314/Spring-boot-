package com.spring.comtroller.demo.controller;

import com.spring.comtroller.demo.bean.Student;
import com.spring.comtroller.demo.result.ResultModel;
import com.spring.comtroller.demo.result.ResultModelTool;
import com.spring.comtroller.demo.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    IStudent studentService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResultModel getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        Map<String,List<Student>> studentMap = new HashMap<>();
        if (studentList!=null){
            studentMap.put("students",studentList);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(studentMap);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/addStudent")
    public ResultModel addStudent(@RequestParam long id,@RequestParam String name){
        Student student = new Student(id,name);
        int errorCode = studentService.addStudent(student);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(student);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/updateStudent")
    public ResultModel updateStudent(@RequestParam long id,@RequestParam String name){
        Student student = new Student(id,name);
        int errorCode = studentService.updateStudent(student);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(student);
        return ResultModelTool.handleResultModel(resultModel);
    }
    @GetMapping(value = "/deleteStudent/{id}")
    public ResultModel deleteStudent(@PathVariable long id){
        int errorCode = studentService.deleteStudent(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        List<Student> studentList = studentService.getAllStudent();
        Map<String,List<Student>> studentMap = new HashMap<>();
        if (studentList!=null){
            studentMap.put("students",studentList);
        }
        resultModel.setData(studentMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
