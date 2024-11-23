package com.braiso_22.spring_boot_demo.student.presentation

import com.braiso_22.spring_boot_demo.student.domain.Student
import com.braiso_22.spring_boot_demo.student.domain.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["student"])
class StudentController(
    @Autowired
    private val studentService: StudentService
) {
    @GetMapping
    fun getStudents(): List<Student> = studentService.getStudents()

    @PostMapping
    fun registerStudent(@RequestBody student: Student) = studentService.addNewStudent(student)
}
