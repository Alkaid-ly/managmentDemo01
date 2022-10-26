package com.example.managementdemo01.mapper;


import com.example.managementdemo01.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> selectAll();

    Student selectById(int id);

    List<Student> selectByConditions(Student student);

    int updateStudent(Student student);

    int loginStudent(Student student);

    void addStudent(Student student);

    @Select("select * from student where sid=#{sid} and password=#{password}")
    Student selectStudent(@Param("sid") String sid,@Param("password") String password);

}
