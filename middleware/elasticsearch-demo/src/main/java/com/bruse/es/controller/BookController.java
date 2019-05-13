package com.bruse.es.controller;

import com.bruse.es.entity.Book;
import com.bruse.es.repository.BookRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("add")
    public void add() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setReleaseDate("2003-01-01");
        bookRepository.save(book);
    }

    @GetMapping("query/{queryString}")
    public Object query(@PathVariable("queryString") String queryString) {
        List<Book> bookList = new ArrayList<>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Book> searchResult = bookRepository.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            System.out.println(next);
            bookList.add(next);
        }
        return bookList;
    }
}
