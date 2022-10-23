package com.example.managementdemo01.controller;


import com.example.managementdemo01.mapper.StudentMapper;
import com.example.managementdemo01.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @GetMapping("/selectAll")
    List<Student> selectAll(){
        List<Student> students = studentMapper.selectAll();
        return students;
    }
    @GetMapping("/selectById")
    Student selectById(String id){
        Student student=studentMapper.selectById(Integer.parseInt(id));
        return student;
    }
    @GetMapping("/selectByConditions")
    List<Student> selectByConditions(@Param("username") String username, @Param("gender") String gender, @Param("grade")String grade, @Param("age")String age, @Param("phone")String phone){
        Student student = new Student();
        if(username!=null){
            username="%"+username+"%";
            student.setUsername(username);
        }
        if(gender!=null){
        student.setGender(gender);
        }
        if(grade!=null) {
            student.setGrade(grade);
        }
        if(age!=null) {
            student.setAge(age);
        }
        if(phone!=null){
            phone="%"+phone+"%";
            student.setPhone(phone);
        }
        System.out.println(student);
        List<Student>students=studentMapper.selectByConditions(student);
        return students;
    }
    @GetMapping("/preUpdateStudent")
    void preUpdateStudent(@Param("id") String id){

    }
    @PostMapping("/UpdateStudent")
    int updateStudent(@Param("username") String username,@Param("password") String password, @Param("gender") String gender, @Param("grade")String grade, @Param("age")String age, @Param("phone")String phone){
        Student student=new Student();
        if(username!=null){
            student.setUsername(username);
        }
        if(password!=null){
            student.setPassword(password);
        }
        if(gender!=null){
            student.setGender(gender);
        }
        if(grade!=null) {
            student.setGrade(grade);
        }
        if(age!=null) {
            student.setAge(age);
        }
        if(phone!=null){
            student.setPhone(phone);
        }
        System.out.println(student);
        int result = studentMapper.updateStudent(student);
        if(result>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return result;
    }
    @GetMapping("/loginStudent")
    public ModelAndView loginById(@RequestParam("sid") String sid, @RequestParam("password") String password){
        Student student = studentMapper.selectStudent(sid, password);
        boolean flag=false;
        if(student!=null){
            flag=true;
            return new ModelAndView("redirect/localhost:8080/student.html");
        }
        return null;
    }
//    List<Student> selectByCondition(String username,String gender)
}
