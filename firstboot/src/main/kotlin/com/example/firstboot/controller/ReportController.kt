package com.example.firstboot.controller

import com.example.firstboot.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("students")
class StudentsController(
    val studentRepository: StudentRepository
) {
    @GetMapping
    fun findAll(): Iterable<ViewStudent> {
        return studentRepository.findAll().map { it.toView() }
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
