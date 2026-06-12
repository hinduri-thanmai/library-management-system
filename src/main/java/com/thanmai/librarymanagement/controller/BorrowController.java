package com.thanmai.librarymanagement.controller;

import com.thanmai.librarymanagement.dto.BorrowRequestDTO;
import com.thanmai.librarymanagement.entity.BorrowRecord;
import com.thanmai.librarymanagement.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/issue")
    public BorrowRecord issueBook(@RequestBody BorrowRequestDTO borrowRequestDTO) {
        return borrowService.issueBook(borrowRequestDTO);
    }

    @PutMapping("/return/{borrowId}")
    public BorrowRecord returnBook(@PathVariable Long borrowId) {
        return borrowService.returnBook(borrowId);
    }

    @GetMapping("/history/{userId}")
    public List<BorrowRecord> getBorrowHistory(@PathVariable Long userId) {
        return borrowService.getBorrowHistory(userId);
    }
}