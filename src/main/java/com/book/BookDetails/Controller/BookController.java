package com.book.BookDetails.Controller;

import com.book.BookDetails.Services.BookService;
import com.book.BookDetails.Units.BookUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Add a new book
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookUnits book) {
        try {
            bookService.Add(book);
            return new ResponseEntity<>("Book added successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing book
    @PutMapping("/{title}")
    public ResponseEntity<String> updateBook(@RequestBody BookUnits book, @PathVariable String title) {
        try {
            bookService.update(book, title);
            return new ResponseEntity<>("Book updated successfully.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public  ResponseEntity<List<BookUnits>> getAllBooks(){
        List<BookUnits> Books = bookService.getall();
        if(!Books.isEmpty()) {
            return new ResponseEntity<>(bookService.getall(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookUnits> getBookByTitle(@PathVariable String title) {
        BookUnits book = bookService.findByTitle(title);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<String> deleteBook(@PathVariable String title) {
        try {
            bookService.delete(title);
            return new ResponseEntity<>("Book deleted successfully.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
