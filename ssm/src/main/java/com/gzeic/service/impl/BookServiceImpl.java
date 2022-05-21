package com.gzeic.service.impl;

import com.gzeic.dao.BookMapper;
import com.gzeic.pojo.Book;
import com.gzeic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    /**
     *
     */
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById( id );
    }
}
