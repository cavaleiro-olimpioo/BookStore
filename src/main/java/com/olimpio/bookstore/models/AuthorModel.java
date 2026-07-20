package com.olimpio.bookstore.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_AUTHOR")
public class AuthorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    public void setId(UUID id) { this.id = id; }
    public UUID getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
}
