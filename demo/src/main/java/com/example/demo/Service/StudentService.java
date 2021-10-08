package com.example.demo.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getstudentList(){
        return studentRepository.findAll();
    }

    public void addNewStudent(student student) {
        Optional<student> studentOptional = studentRepository
                .FindStudentbyEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
       studentRepository.findById(studentID);
       boolean exists = studentRepository.existsById(studentID);
        if(!exists) {
            throw new IllegalStateException("student with id " + studentID + " does not exitst");
        }
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {

        student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentID + " does not exist"
                ));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)) {
            Optional<student> studentOptional = studentRepository
                    .FindStudentbyEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
