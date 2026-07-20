package com.olimpio.bookstore.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    public void setId(UUID id) { this.id = id; }
    public UUID getId() { return id; }

    public void setTitle(String title) { this.title = title; }
    public String getTitle() { return title; }
}
