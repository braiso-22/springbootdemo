package com.braiso_22.spring_boot_demo.student.domain

interface StudentService {
    fun getStudents(): List<Student>
    fun addNewStudent(student: Student)
}
