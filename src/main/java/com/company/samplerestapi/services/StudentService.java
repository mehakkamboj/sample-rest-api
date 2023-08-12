package com.company.samplerestapi.services;

import com.company.samplerestapi.model.Student;
import com.company.samplerestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    //    DEPENDENCY INJECTION = AUTO-WIRING
//    This is a data fetched from database
    List<Student> Students =  new ArrayList<>(Arrays.asList(
            new Student("1", "Student One", "CSE", "USET"),
            new Student("2", "Student Two", "CSE", "USET"),
            new Student("3", "Student Three", "CSE", "USET"),
            new Student("4", "Student Four", "CSE", "USET"),
            new Student("5", "Student Five", "CSE", "USET")
    )
    );

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Optional<Student> getStudentInfo(String rno) {
//        optional is function which returns value if it find the data else returns null
//        return Students.stream().filter(s -> s.getRno().equals(rno)).findFirst().get();
          return studentRepository.findById(rno);
//        studentRepository.findAllById()-->works when we have duplicate id
    }

    public void addStudent(Student student) {
//        Students.add(student);
        studentRepository.save(student);
    }


    public void editStudent(String rno, Student updatedStudent){
        for (int i=0; i<Students.size(); i++)
        {
            Student s = Students.get(i);
            if (s.getRno().equals(rno)){
                Students.set(i, updatedStudent);
            }
        }
    }
    public Optional<Student> deleteStudent(String rno){
        Optional<Student> student = studentRepository.findById(rno);
        studentRepository.deleteById(rno);
        return student;
    }

}