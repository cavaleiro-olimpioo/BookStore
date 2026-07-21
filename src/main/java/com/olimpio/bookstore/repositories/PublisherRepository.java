package com.olimpio.bookstore.repositories;

import com.olimpio.bookstore.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<AuthorModel, UUID> {
}
