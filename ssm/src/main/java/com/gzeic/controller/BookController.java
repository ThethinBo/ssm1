package com.gzeic.controller;

import com.gzeic.pojo.Book;
import com.gzeic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping( "/book" )
    public ModelAndView findBookById( Integer id ){
        Book book = bookService.findBookById( id );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "book", book );
        modelAndView.setViewName( "book.jsp" );
        return modelAndView;
    }

    @RequestMapping( "/Demo")
    @ResponseBody
    public String demo(){
        return "hello world";
    }
}
