package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.Book;
import com.kgisl.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        // TODO Auto-generated method stub
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book bookCategory) {
        // TODO Auto-generated method stub
        return bookRepository.saveAndFlush(bookCategory);

    }

    // @Override
    // public Book find(long id) {
    //     // TODO Auto-generated method stub
    //     return bookRepository.findById(id);
    // }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        bookRepository.deleteById(id);
    }

}
