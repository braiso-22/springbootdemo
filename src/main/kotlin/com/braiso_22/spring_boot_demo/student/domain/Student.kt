package com.braiso_22.spring_boot_demo.student.domain

import java.time.LocalDate

data class Student(
    val id: Long,
    val name: String,
    val birthDate: LocalDate,
    val email: String,
) {
    fun getAge() = birthDate.until(LocalDate.now()).years
}
