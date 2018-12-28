package com.kgisl.repository;

import com.kgisl.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookRepository
 */
public interface BookRepository extends JpaRepository<Book,Long>{

    
}