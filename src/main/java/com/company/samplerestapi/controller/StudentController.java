package com.company.samplerestapi.controller;

import com.company.samplerestapi.model.Student;
import com.company.samplerestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //    service dependency -inject -Dependency injection
//    function which returns a list of person as a response
    @RequestMapping(method = RequestMethod.GET, value = "/Students")
    public List<Student> getAllPersons() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Students/{rno}")
    public Optional<Student> getStudentInfo(@PathVariable String rno) {
        return studentService.getStudentInfo(rno);
    }

    // POST - localhost -8080/students -> Enrolled/Add a Student
    @RequestMapping(method = RequestMethod.POST, value = "/Students")
    public Student addStudent(@RequestBody Student student) {
       studentService.addStudent(student);
        return student;
    }


    // PUT -localhost8080/students/rna -> edit the info of the student whose rna is passes
    @RequestMapping(method = RequestMethod.PUT, value = "/Students/{rno}")
    public Student editStudent(@PathVariable String rno, @RequestBody Student student) {
        studentService.editStudent(rno, student);
        return student;
    }
//    DELETE - localhost/8081/Students/{rno} -> remove the student whose rno is passed
    @RequestMapping(method = RequestMethod.DELETE, value = "/Students/{rno}")
    public Optional<Student> deleteStudent(@PathVariable String rno){
        return studentService.deleteStudent(rno);
    }

}