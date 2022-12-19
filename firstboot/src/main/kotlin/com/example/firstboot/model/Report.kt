package com.example.firstboot.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository

@Entity
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",
)

interface StudentRepository: CrudRepository<Student, Long>

@Entity
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",
)

interface CourseRepository: CrudRepository<Course, Long>

data class ViewStudent (
    val id: Long,
    val name: String,
)

fun Student.toView() = ViewStudent(id, name)

data class ViewCourse(
    val id: Long,
    val name: String,
)

fun Course.toView() = ViewCourse(id, name)
