package com.harit.library.library_management_system.controller;

import com.harit.library.library_management_system.entity.Book;
import com.harit.library.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(){

    }
    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book requestedBook = bookService.getBook(id);
        if (requestedBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(requestedBook);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        if(allBooks.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allBooks);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookService.updateBook(id , book);
        if(updatedBook == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
        if(book != null){
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
