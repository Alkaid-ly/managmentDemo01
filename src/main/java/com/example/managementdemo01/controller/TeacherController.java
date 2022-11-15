package com.example.managementdemo01.controller;

import com.example.managementdemo01.mapper.TeacherMapper;
import com.example.managementdemo01.pojo.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @RequestMapping(value = "/addMission",method = RequestMethod.POST)
    public int addStudent(String mtitle,String context,String fk_tid,String fk_sid){
        Mission mission=new Mission();
        int mid = (int)(Math.random()*(99999999-10000000))+10000000;
        String Mid=Integer.toString(mid);
            mission.setMid(Mid);
            mission.setMtitle(mtitle);
            mission.setContext(context);
            mission.setFk_tid("2022001");
            mission.setFk_sid(fk_sid);
        System.out.println(mission);
        teacherMapper.addMission(mission);
        return 1;
    }
    @CrossOrigin
    @GetMapping("/selectAllMission")
    List<Mission> selectAllMission(){
        List<Mission> missions = teacherMapper.selectAllMission();
        return missions;
    }
}
