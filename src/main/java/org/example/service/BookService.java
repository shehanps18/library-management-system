package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

public interface BookService {
    void addBook(Book book);
    Iterable<BookEntity> getBook();
//    boolean deleteBook(Long id);

    Book getBookById(Long id);
    boolean removeBook(Long bookId);

}
