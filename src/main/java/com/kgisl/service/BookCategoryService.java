package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.BookCategory;



public interface BookCategoryService {

    public List<BookCategory> getAll();

    public BookCategory save(BookCategory event);

    // public BookCategory find(long id);

    public void delete(Long id);

}
