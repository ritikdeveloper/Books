package com.book.BookDetails.Units;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class BookUnits {

    @Id
    @NotEmpty(message = "ISBN cannot be empty")
    @Size(min = 2, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotNull(message = "Year cannot be null")
    private int year;
    @NotNull(message = "Price cannot be null")
    private double price;
    private String genre;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<AuthorUnits> authors;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<AuthorUnits> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorUnits> authors) {
        this.authors = authors;
    }
}
