package com.olimpio.bookstore.repositories;

import com.olimpio.bookstore.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    BookModel findBookModelsByTitle(String title);
    BookModel findBookModelsById(UUID id);
}
