package com.braiso_22.spring_boot_demo.student.presentation

import com.braiso_22.spring_boot_demo.student.domain.Student
import com.braiso_22.spring_boot_demo.student.domain.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(
    @Autowired
    private val studentService: StudentService
) {
    @GetMapping
    fun getStudents(): ResponseEntity<List<Student>> = ResponseEntity.ok(
        studentService.getStudents()
    )

    @PostMapping
    fun registerStudent(@RequestBody student: Student): ResponseEntity<Any> = try {
        val createdStudent = studentService.addNewStudent(student)
        ResponseEntity.status(HttpStatus.CREATED).body(createdStudent)
    } catch (e: IllegalStateException) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
    }


    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            studentService.deleteStudent(id)
            ResponseEntity.noContent().build()
        } catch (e: IllegalStateException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
        }
    }

    @PutMapping
    fun updateStudent(
        @RequestBody student: Student
    ): ResponseEntity<Any> {
        return try {
            studentService.updateStudent(student)
            ResponseEntity.status(HttpStatus.ACCEPTED).body(student)
        } catch (e: IllegalStateException) {
            ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(e.message)
        }
    }
}
