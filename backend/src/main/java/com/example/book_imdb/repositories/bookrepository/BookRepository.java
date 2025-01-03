package com.example.book_imdb.repositories.bookrepository;

import com.example.book_imdb.entities.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository{

    @Autowired
    private BookRowMapper mapper;

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookEntity> findAllBooks(){
        String sql = "SELECT * FROM books";
         List<BookEntity> books = jdbcTemplate.query(sql, mapper);
         return books;
    }

    public void createBook(BookEntity book){
        String sql = "INSERT INTO books(title,author,description,release_date)" + "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getDescription(), book.getReleaseDate());

    }

    public BookEntity findBookById(Integer book_id){
           String sql = "SELECT * FROM books WHERE book_id = ?";
           System.out.println(book_id);
           BookEntity book = jdbcTemplate.queryForObject(sql,mapper,book_id);
           return book;
    }
    public void DeleteBook(Integer book_id){
        String sql = "DELETE FROM BOOKS WHERE book_id = ?";
        jdbcTemplate.update(sql, book_id);
    }

}
