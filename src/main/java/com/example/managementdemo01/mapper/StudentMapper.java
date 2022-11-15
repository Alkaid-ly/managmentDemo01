package com.example.managementdemo01.mapper;


import com.example.managementdemo01.pojo.Mission;
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
    List<Student> assessment();

    Student selectById(String id);

    List<Student> selectByConditions(Student student);

    int updateStudent(Student student);

    int loginStudent(Student student);

    void addStudent(Student student);

    int deleteStudent(String sid);
    List<Mission> myMission(String sid);
    @Select("select * from mission where mid=#{mid}")
    Mission showMission(String mid);

    int completeMission( String mid);


    @Select("select * from student where sid=#{sid} and password=#{password}")
    Student selectStudent(@Param("sid") String sid,@Param("password") String password);

}
