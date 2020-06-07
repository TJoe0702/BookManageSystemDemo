package com.example.BootVue.service;

import com.example.BootVue.entity.Book;
import com.example.BootVue.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author tujun
 * @date 2020/6/4 -14:50
 */
@Service
public class BookServiceImp implements BookService{

    @Resource
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
