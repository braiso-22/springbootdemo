package com.braiso_22.spring_boot_demo.student.domain

interface StudentRepository {
    fun findAll(): List<Student>
    fun findByEmail(email: String): Student?
    fun findById(id: Long): Student?
    fun save(student: Student): Student
    fun deleteById(id: Long)
}