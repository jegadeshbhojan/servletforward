package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.BookCategory;
import com.kgisl.repository.BookCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookCategoryServiceImp implements BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getAll() {
        // TODO Auto-generated method stub
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory save(BookCategory bookCategory) {
        // TODO Auto-generated method stub
        return bookCategoryRepository.saveAndFlush(bookCategory);

    }

    // @Override
    // public BookCategory find(long id) {
    //     // TODO Auto-generated method stub
    //     return bookCategoryRepository.findById(id);
    // }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        bookCategoryRepository.deleteById(id);
    }

}
