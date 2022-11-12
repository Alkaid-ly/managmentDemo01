package com.example.managementdemo01.controller;

import com.example.managementdemo01.mapper.TeacherMapper;
import com.example.managementdemo01.pojo.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @RequestMapping(value = "/addMission",method = RequestMethod.POST)
    public int addStudent(String mid,String mtitle,String context,String fk_tid,String fk_sid){
        Mission mission=new Mission();
        if(mid!=null){
            mission.setMid(mid);
        }
            mission.setMtitle(mtitle);
            mission.setContext(context);
            mission.setFk_tid("2022001");
            mission.setFk_sid(fk_sid);
        System.out.println(mission);
        teacherMapper.addMission(mission);
        return 1;
    }
}
