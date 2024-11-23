package com.braiso_22.spring_boot_demo.student.domain

import com.braiso_22.spring_boot_demo.student.data.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<StudentEntity, Long> {
    fun findByEmail(email:String): StudentEntity?
}