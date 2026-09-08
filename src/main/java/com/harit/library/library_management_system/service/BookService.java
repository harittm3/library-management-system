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

    public Book addBook(Book requestedBook){
        Book addedBook = bookRepo.save(requestedBook);
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

    public Book updateBook(Long id , Book givenBook){
        Optional<Book> existingBook = bookRepo.findById(id);
        if(existingBook.isEmpty()){
            return null;
        }

        Book bookToSave = existingBook.get();

        bookToSave.setIsbn(givenBook.getIsbn());
        bookToSave.setTitle(givenBook.getTitle());
        bookToSave.setAuthor(givenBook.getAuthor());
        bookToSave.setPublisher(givenBook.getPublisher());
        bookToSave.setTotalCopies(givenBook.getTotalCopies());
        bookToSave.setAvailableCopies(givenBook.getAvailableCopies());
        bookToSave.setBookStatus(givenBook.getBookStatus());

        return bookRepo.save(bookToSave);
    }

    public void deleteBook(Long id){
        if(bookRepo.existsById(id)){
            bookRepo.deleteById(id);
        }
    }
}
