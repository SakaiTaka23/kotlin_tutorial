package com.example.firstboot.model

import jakarta.persistence.*
import org.springframework.data.repository.CrudRepository

@Entity
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    @ManyToMany
    @JoinTable(
        name = "student_enrolled_in_course",
        joinColumns = arrayOf(JoinColumn(name = "student_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "course_id"))
    )
    val enrolledIn: List<Course> = listOf(),
)

interface StudentRepository: CrudRepository<Student, Long>

@Entity
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    @ManyToMany(mappedBy = "enrolledIn")
    val studentsEnrolledIn: List<Student> = listOf()
)

interface CourseRepository: CrudRepository<Course, Long>

data class ViewStudent (
    val id: Long,
    val name: String,
    val coursesEnrolledIn: Iterable<String>
)

fun Student.toView() = ViewStudent(id, name, enrolledIn.map { it.name })

data class ViewCourse(
    val id: Long,
    val name: String,
    val student: Iterable<String>
)

fun Course.toView() = ViewCourse(id, name, studentsEnrolledIn.map { it.name })
