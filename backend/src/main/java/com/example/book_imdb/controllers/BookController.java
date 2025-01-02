package com.example.book_imdb.controllers;

import com.example.book_imdb.dtos.BookDto;
import com.example.book_imdb.entities.BookEntity;
import com.example.book_imdb.repositories.bookrepository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping()
    public ResponseEntity findAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAllBooks());
    }

    @GetMapping("/{book_id}")
    public ResponseEntity findBookById(@PathVariable(value = "book_id") Integer bookId){
        System.out.println(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(repository.findBookById(bookId));
    }

    @PostMapping()
    public ResponseEntity postBook(@RequestBody BookDto bookDto){
        BookEntity book = new BookEntity();
        BeanUtils.copyProperties(bookDto, book);
        repository.createBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
