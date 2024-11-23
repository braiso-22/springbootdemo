package com.braiso_22.spring_boot_demo.student.config

import com.braiso_22.spring_boot_demo.student.data.StudentEntity
import com.braiso_22.spring_boot_demo.student.domain.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfig {
    @Bean
    fun commandLineRunner(repository: StudentRepository): CommandLineRunner = CommandLineRunner {
        repository.saveAll(
            listOf(
                StudentEntity(
                    name = "Leonard England",
                    birthDate = LocalDate.of(
                        1995, Month.APRIL, 4
                    ),
                    email = "eleanor.kent@example.com"
                ),
                StudentEntity(
                    name = "Doug Hull",
                    birthDate = LocalDate.of(
                        1980, Month.MARCH, 13
                    ),
                    email = "henrietta.lane@example.com",
                )
            )
        )
    }
}