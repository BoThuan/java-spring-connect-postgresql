package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<student> getstudentList(){
        return studentService.getstudentList();
    }

    @PostMapping
    public void registerStudent(@RequestBody student student){
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentID,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentID, name, email);
    }

    @DeleteMapping(path = "{studentID}")
    public void DeleteStudent(@PathVariable("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }
}
