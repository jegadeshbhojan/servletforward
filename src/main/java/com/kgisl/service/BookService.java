package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.Book;



public interface BookService {

    public List<Book> getAll();

    public Book save(Book event);

    // public Book find(long id);

    public void delete(Long id);

}
