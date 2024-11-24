package com.braiso_22.spring_boot_demo.student.data

import com.braiso_22.spring_boot_demo.student.domain.Student
import com.braiso_22.spring_boot_demo.student.domain.StudentRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class StudentRepositoryImpl(
    private val jpaRepository: StudentRepositoryJpa
) : StudentRepository {
    override fun findAll(): List<Student> = jpaRepository.findAll().map {
        it.toDomain()
    }

    override fun findByEmail(email: String): Student? = jpaRepository.findByEmail(email)?.toDomain()

    override fun findById(id: Long): Student? = jpaRepository.findById(id).getOrNull()?.toDomain()

    override fun save(student: Student): Student = jpaRepository.save(student.toEntity()).toDomain()
    override fun deleteById(id: Long) = jpaRepository.deleteById(id)
}