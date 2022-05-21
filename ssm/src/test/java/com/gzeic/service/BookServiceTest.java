package com.gzeic.service;

import com.gzeic.pojo.Book;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:unused/application-service.xml")
public class BookServiceTest extends TestCase {

    @Autowired
    private BookService bookService;

    @Test
    public void findBookById(){
        Book book = bookService.findBookById(1);
        System.out.println(book);
    }
}