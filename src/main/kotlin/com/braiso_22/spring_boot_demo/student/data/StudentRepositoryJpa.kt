package com.braiso_22.spring_boot_demo.student.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepositoryJpa : JpaRepository<StudentEntity, Long> {
    fun findByEmail(email:String): StudentEntity?
}