package com.example.book_imdb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


public class BookEntity {

    private Integer book_id;
    private String title;
    private String author;
    private String description;
    private LocalDate releaseDate;
    private BigDecimal rating;

    public BookEntity(Integer book_id, String title, String author,String description, LocalDate releaseDate, BigDecimal rating) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public BookEntity() {

    }

    public Integer getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
