package com.example.book_imdb.dtos;

import java.time.LocalDate;

public record BookDto(String title, String author, String description, LocalDate releaseDate) {
}
