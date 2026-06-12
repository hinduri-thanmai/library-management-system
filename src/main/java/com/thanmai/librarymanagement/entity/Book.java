package com.thanmai.librarymanagement.entity;

import com.thanmai.librarymanagement.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    private String author;

    @Column(unique = true)
    private String isbn;

    private String category;

    private Integer quantity;

    private Integer availableQuantity;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}