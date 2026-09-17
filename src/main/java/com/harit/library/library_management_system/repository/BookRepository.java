package com.harit.library.library_management_system.repository;

import com.harit.library.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book , Long> {

    public Optional<Book> findByIdAndIsDeletedFalse(Long id);

    public List<Book> findAllByIsDeletedFalse();
}
