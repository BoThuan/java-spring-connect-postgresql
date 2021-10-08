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
             student tam = new student(
                    1L,
                    "tam",
                    "tam@gmail.com",
                    LocalDate.of(2001, Month.OCTOBER, 01)
            );

             repository.saveAll(
                     List.of(thuan, tam)
             );
        };
    }
}
