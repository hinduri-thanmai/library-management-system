package com.thanmai.librarymanagement.service;

import com.thanmai.librarymanagement.dto.BorrowRequestDTO;
import com.thanmai.librarymanagement.entity.BorrowRecord;

import java.util.List;

public interface BorrowService {

    BorrowRecord issueBook(BorrowRequestDTO borrowRequestDTO);

    BorrowRecord returnBook(Long borrowId);

    List<BorrowRecord> getBorrowHistory(Long userId);
}