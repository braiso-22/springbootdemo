package com.braiso_22.spring_boot_demo

import com.braiso_22.spring_boot_demo.student.domain.Student
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@SpringBootApplication

class SpringBootDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringBootDemoApplication>(*args)
}
