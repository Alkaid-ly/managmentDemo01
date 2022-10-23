package com.example.managementdemo01.mapper;

import com.example.managementdemo01.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> selectAll();
}
