package com.nest.studentapp_new_backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.nest.studentapp_new_backend.dao.StudentDao;
import com.nest.studentapp_new_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class studentcontroller {
    @Autowired
    private StudentDao dao;
    @GetMapping("/")
    public String Homepage()
    {
        return "Welcome to home page";
    }
//    @GetMapping("/contact")
//    public String Contact()
//    {
//        return "Welcome to contact page";
//    }
//    @GetMapping("/gallery")
//    public String gallery()
//            {
//              return "Gallery";
//            }
            @CrossOrigin(origins = "*")
            @PostMapping(path = "/addStudents", consumes = "application/json",produces = "application/json")
            public Map<String,String> addStudents(@RequestBody Students s)
            {

                System.out.println(s.getName().toString());
                System.out.println(s.getAdmnno());
                System.out.println(s.getRollno());
                System.out.println(s.getCollege().toString());
                dao.save(s);
                HashMap<String,String> map=new HashMap<>();
                map.put("status","success");
                return map;
            }
            @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> viewStudent()
    {
        return (List<Students>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces ="application/json")
    public  List<Students> SearchStudent(@RequestBody Students s)
    {
        int admissionNo=s.getAdmnno();
        System.out.println(admissionNo);
        return (List<Students>) dao.SearchStudent(s.getAdmnno());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public Map<String,String> DeleteStudent(@RequestBody Students s)
    {
        String id=String.valueOf(s.getId());
        System.out.println(id);
        dao.DeleteStudent(s.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}
