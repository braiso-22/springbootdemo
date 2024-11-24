package com.braiso_22.spring_boot_demo.student.presentation

import com.braiso_22.spring_boot_demo.student.domain.Student
import com.braiso_22.spring_boot_demo.student.domain.StudentRepository
import com.braiso_22.spring_boot_demo.student.domain.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(
    @Autowired
    val studentRepository: StudentRepository
) : StudentService {
    override fun getStudents(): List<Student> = studentRepository.findAll()

    override fun addNewStudent(student: Student): Student {
        val studentFound: Student? = studentRepository.findByEmail(student.email)
        studentFound?.let {
            throw IllegalStateException("Email already exists")
        }

        return studentRepository.save(student.copy(id = 0))
    }

    override fun deleteStudent(id: Long) {
        val studentFound: Student? = studentRepository.findById(id)
        studentFound?.let {
            studentRepository.deleteById(id)
        } ?: throw IllegalStateException("User doesn't exist")
    }

    override fun updateStudent(student: Student) {
        val studentFound: Student? = studentRepository.findById(student.id)
        studentFound?.let {
            studentRepository.save(student)
        } ?: throw IllegalStateException("User doesn't exist")
    }
}
