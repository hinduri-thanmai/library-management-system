package com.thanmai.librarymanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRequestDTO {

    private Long userId;
    private Long bookId;
}