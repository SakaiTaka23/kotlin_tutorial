package com.book.manager.presentation.aop

import com.book.manager.application.service.security.BookManagerUserDetails
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

private val logger = LoggerFactory.getLogger(LoggingAdvice::class.java)

@Aspect
@Component
class LoggingAdvice {
    @Before("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun beforeLog(joinPoint: JoinPoint) {
        val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetails
        logger.info("Start: ${joinPoint.signature} userId = ${user.id}")
        logger.info("Class: ${joinPoint.target.javaClass}")
        logger.info(
            "Session: ${(RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request.session.id}"
        )
    }

    @After("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun afterLog(joinPoint: JoinPoint) {
        val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetails
        logger.info("End: ${joinPoint.signature} userId = ${user.id}")
    }

    @Around("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun aroundLog(joinPoint: ProceedingJoinPoint): Any? {
        val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetails
        logger.info("Start: ${joinPoint.signature} userId = ${user.id}")

        // これが処理本体
        val result = joinPoint.proceed()

        logger.info("End: ${joinPoint.signature} userId = ${user.id}")
        return result
    }

    @AfterReturning("execution(* com.book.manager.presentation.controller..*.*(..))", returning = "returnValue")
    fun afterReturningLog(joinPoint: JoinPoint, returnValue: Any?) {
        logger.info("End: ${joinPoint.signature} returnValue = $returnValue")
    }

    @AfterThrowing("execution(* com.book.manager.presentation.controller..*.*(..))", throwing = "e")
    fun afterThrowing(joinPoint: JoinPoint, e: Throwable) {
        logger.error("Exception: ${e.javaClass} signature = ${joinPoint.signature} message = ${e.message}")
    }
}
