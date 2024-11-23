package com.braiso_22.spring_boot_demo.student.presentation

import com.braiso_22.spring_boot_demo.student.data.StudentEntity
import com.braiso_22.spring_boot_demo.student.data.toEntity
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
    override fun getStudents(): List<Student> {
        return studentRepository.findAll().map {
            it.toDomain()
        }
    }

    override fun addNewStudent(student: Student) {
        val studentFound: StudentEntity? = studentRepository.findByEmail(student.email)
        studentFound?.let {
            throw IllegalStateException("Email already exists")
        }

        studentRepository.save(student.toEntity())
    }
}
