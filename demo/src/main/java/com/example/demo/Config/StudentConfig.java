package com.example.demo.Config;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
             student thuan = new student(
                    1L,
                    "thuan",
                    "bothuan@gmail.com",
                    LocalDate.of(2001, Month.JULY, 13)
            );
             student giang = new student(
                    2L,
                    "giang",
                    "giang@gmail.com",
                    LocalDate.of(2000, Month.JUNE,22)
            );
             student nhi = new student(
                    1L,
                    "nhi",
                    "nhi@gmail.com",
                    LocalDate.of(2002, Month.DECEMBER, 13)
            );
             student tam = new student(
                    1L,
                    "tam",
                    "tam@gmail.com",
                    LocalDate.of(2003, Month.OCTOBER, 15)
            );

             repository.saveAll(
                     List.of(thuan,giang,nhi, tam)
             );
        };
    }
}
