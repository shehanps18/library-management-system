package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

public interface BookService {
    void addBook(Book book);
    Iterable<BookEntity> getBook();

}
