package com.example.firstboot.controller

import com.example.firstboot.model.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

data class EnrollInCourse(
    val courseId: Long
)

@RestController
@RequestMapping("students")
class StudentsController(
    val studentRepository: StudentRepository,
    val courseRepository: CourseRepository
) {
    @GetMapping
    fun findAll(): Iterable<ViewStudent> {
        return studentRepository.findAll().map { it.toView() }
    }

    @PostMapping("{id}/enroll")
    fun enroll(@PathVariable id: Long, @RequestBody enrollIn: EnrollInCourse): ViewStudent {
        val student = studentRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        val course = courseRepository.findById(enrollIn.courseId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        val created =  studentRepository.save(
            student.copy(
                enrolledIn = student.enrolledIn.plus(course)
            )
        )
        return created.toView()
    }
}

@RestController
@RequestMapping("courses")
class CourseController(
    val courseRepository: CourseRepository
) {
    @GetMapping
    fun findAll(): Iterable<ViewCourse> {
        return courseRepository.findAll().map { it.toView() }
    }
}
