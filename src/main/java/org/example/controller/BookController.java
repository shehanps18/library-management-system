package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    final BookService service;

    @CrossOrigin
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping ("/get")
    public Iterable<BookEntity> getBooks(){

        return service.getBook();
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteBook(@PathVariable Long id){
//        return service.deleteBook(id) ?
//            ResponseEntity.ok("Deleted"):
//            ResponseEntity.notFound().build();
//    }
    @GetMapping("search/{id}")
        public Book getBookById(@PathVariable Long id){

        return service.getBookById(id);

    }
    @DeleteMapping("/delete/{bookId}")
    Map<String, String> removeBook(@PathVariable Long bookId){
        return service.removeBook(bookId) ?
                Collections.singletonMap("status",String.format("Book Id %s Deleted",bookId)):
                Collections.singletonMap("status",String.format("Book Id %s Invalid",bookId));
        }
}
