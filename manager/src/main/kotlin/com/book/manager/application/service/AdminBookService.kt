package com.book.manager.application.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.repository.BookRepository
import java.time.LocalDate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminBookService(
    private val bookRepository: BookRepository,
) {
    @Transactional
    fun register(book: Book) {
        bookRepository.findWithRental(book.id)?.let { throw IllegalArgumentException("既に存在する書籍ID：${book.id}") }
        bookRepository.register(book)
    }

    @Transactional
    fun update(bookId: Long, title: String?, author: String?, relaseDate: LocalDate?) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
        bookRepository.update(bookId, title, author, relaseDate)
    }

    @Transactional
    fun delete(bookId: Long) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
        bookRepository.delete(bookId)
    }
}
