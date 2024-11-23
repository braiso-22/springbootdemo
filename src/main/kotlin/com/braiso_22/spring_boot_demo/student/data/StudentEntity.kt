package com.braiso_22.spring_boot_demo.student.data

import com.braiso_22.spring_boot_demo.student.domain.Student
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    name = "student"
)
data class StudentEntity(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence",
    )
    val id: Long = 0,
    val name: String,
    val birthDate: LocalDate,
    val email: String,
) {
    fun toDomain(): Student = Student(
        id = id,
        name = name,
        birthDate = birthDate,
        email = email
    )
}

fun Student.toEntity() = StudentEntity(
    id = id,
    name = name,
    birthDate = birthDate,
    email = email,
)
