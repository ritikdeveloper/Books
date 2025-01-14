package com.book.BookDetails.Repository;

import com.book.BookDetails.Units.AuthorUnits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<AuthorUnits,Integer> {
}
