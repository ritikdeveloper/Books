package com.book.BookDetails.Services;

import com.book.BookDetails.Repository.BookRepo;
import com.book.BookDetails.Units.BookUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo repo;


    public List<BookUnits> getall(){
        return repo.findAll();
    }

    public void Add(BookUnits book) {
        repo.save(book);
    }

    public void update(BookUnits book, String title) {
        BookUnits oldbook = repo.findByTitle(title);

        if (oldbook != null) {
            book.setAuthors(oldbook.getAuthors());
            book.setTitle(oldbook.getTitle());
            book.setYear(oldbook.getYear());
            book.setPrice(oldbook.getPrice());

            repo.save(book);
        } else {
            throw new RuntimeException("Book with title " + title + " not found.");
        }

    }


    public BookUnits findByTitle(String title){
        return  repo.findByTitle(title);
    }
    public void delete(String title){
        BookUnits book = repo.findByTitle(title);
        repo.delete(book);

    }
}
