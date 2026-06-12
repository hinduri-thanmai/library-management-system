package com.thanmai.librarymanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String title;
    private String author;
    private String isbn;
    private String category;
    private Integer quantity;
}