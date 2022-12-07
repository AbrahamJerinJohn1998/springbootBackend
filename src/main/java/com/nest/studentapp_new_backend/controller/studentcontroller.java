package com.nest.studentapp_new_backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.nest.studentapp_new_backend.dao.StudentDao;
import com.nest.studentapp_new_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            public String addStudents(@RequestBody Students s)
            {

                System.out.println(s.getName().toString());
                dao.save(s);
                return "Student added";
            }
            @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> viewStudent()
    {
        return (List<Students>) dao.findAll();
    }
}
