package com.book.BookDetails.Repository;

import com.book.BookDetails.Units.BookUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookUnits, String> {
    BookUnits findByTitle(String title);
}
