package com.harit.library.library_management_system.service;

import com.harit.library.library_management_system.entity.Book;
import com.harit.library.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    public Book addBook(Book reqestedBook){
        Book addedBook = bookRepo.save(reqestedBook);
        return addedBook;
    }

    public Book getBook(Long id){
        Optional<Book> requestedBook = bookRepo.findById(id);
        return requestedBook.orElse(null);
    }

    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepo.findAll();
        return allBooks;
    }

//    public Book updateBook(Long id , Book book){
//        Book updatedBook = bookRepo.
//    }
}
