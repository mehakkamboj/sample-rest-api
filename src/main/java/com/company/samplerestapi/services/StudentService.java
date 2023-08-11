package com.company.samplerestapi.services;

import com.company.samplerestapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
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
        return Students;
    }

    public Student getStudentInfo(String rno) {
        return Students.stream().filter(s -> s.getRno().equals(rno)).findFirst().get();

    }

    public void addStudent(Student student) {
        Students.add(student);
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

}