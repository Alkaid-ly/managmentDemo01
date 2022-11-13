package com.example.managementdemo01.controller;


import com.example.managementdemo01.mapper.StudentMapper;
import com.example.managementdemo01.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    Student selectById(String sid){
        System.out.println("sid="+sid);
        Student student=studentMapper.selectById(sid);
        return student;
    }
    @GetMapping("/selectByConditions")
    List<Student> selectByConditions(@Param("username") String username, @Param("gender") String gender, @Param("grade")String grade, @Param("major")String major, @Param("position")String position, @Param("age")String age, @Param("phone")String phone){
        Student student = new Student();
        if(username!=null){
            username="%"+username+"%";
            student.setUsername(username);
        }
        if(gender!=null){
        student.setGender(gender);
        }
        if(grade!=null) {
            //去除空格
            grade=grade.trim();
            student.setGrade(grade);
        }
        if(age!=null) {
            student.setAge(age);
        }
        if(major!=null) {
            student.setMajor(major);
        }
        if(position!=null) {
            student.setPosition(position);
        }
        if(phone!=null){
            phone="%"+phone+"%";
            student.setPhone(phone);
        }
        System.out.println(student);
        List<Student>students=studentMapper.selectByConditions(student);
        return students;
    }
    @GetMapping("/loginStudent")
    public void loginById(HttpServletResponse response,@RequestParam("sid") String sid, @RequestParam("password") String password) throws IOException {
        Student student = studentMapper.selectStudent(sid, password);
        System.out.println(student);
        if(student!=null){

            response.sendRedirect("student.html");
            return;
        }
        response.sendRedirect("teacherLogin.html");
    }
    @GetMapping("/chart")
    public void toChart(@NotNull HttpServletResponse response) throws IOException {
        response.sendRedirect("chart.html");
    }
    @GetMapping("/assessment")
    public List<Student> assessment(){
        List<Student> students = studentMapper.assessment();
        return students;
    }
    @GetMapping("/deleteStudent")
    public int deleteStudent(String sid){
        System.out.println(sid);
        int result=0;
        result=studentMapper.deleteStudent(sid);
        return result;
    }
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public int addStudent(String sid,String username,String password,String gender,String grade,String major,String position,String age,String phone){
        Student student=new Student();
        if(sid!=null){
            student.setSid(sid);
        }
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
        if(major!=null) {
            student.setMajor(major);
        }
        if(position!=null) {
            student.setPosition(position);
        }
        if(age!=null) {
            student.setAge(age);
        }else if("".equals(age)){
            student.setAge("Null");
        }
        if(phone!=null){
            student.setPhone(phone);
        }
        System.out.println(student);
        studentMapper.addStudent(student);
        return 1;
    }
    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public int updateStudent(String sid,String username,String password,String gender,String grade,String major,String position,String age,String phone){
        Student student=new Student();
        if(sid!=null){
            student.setSid(sid);
        }
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
        if(major!=null) {
            student.setMajor(major);
        }
        if(position!=null) {
            student.setPosition(position);
        }
        if(age!=null) {
            student.setAge(age);
        }else if("".equals(age)){
            student.setAge("Null");
        }
        if(phone!=null){
            student.setPhone(phone);
        }
        System.out.println(student);
        studentMapper.updateStudent(student);
        return 1;
    }


}
