package com.thanmai.librarymanagement.service.impl;

import com.thanmai.librarymanagement.dto.BorrowRequestDTO;
import com.thanmai.librarymanagement.entity.Book;
import com.thanmai.librarymanagement.entity.BorrowRecord;
import com.thanmai.librarymanagement.entity.User;
import com.thanmai.librarymanagement.enums.BookStatus;
import com.thanmai.librarymanagement.enums.BorrowStatus;
import com.thanmai.librarymanagement.repository.BookRepository;
import com.thanmai.librarymanagement.repository.BorrowRecordRepository;
import com.thanmai.librarymanagement.repository.UserRepository;
import com.thanmai.librarymanagement.service.BorrowService;
import com.thanmai.librarymanagement.util.FineCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BorrowRecord issueBook(BorrowRequestDTO borrowRequestDTO) {

        User user = userRepository.findById(borrowRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(borrowRequestDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableQuantity() <= 0) {
            throw new RuntimeException("Book not available");
        }

        book.setAvailableQuantity(book.getAvailableQuantity() - 1);

        if (book.getAvailableQuantity() == 0) {
            book.setStatus(BookStatus.OUT_OF_STOCK);
        }

        bookRepository.save(book);

        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setUser(user);
        borrowRecord.setBook(book);
        borrowRecord.setIssueDate(LocalDate.now());
        borrowRecord.setDueDate(LocalDate.now().plusDays(14));
        borrowRecord.setStatus(BorrowStatus.ISSUED);
        borrowRecord.setFineAmount(0.0);

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public BorrowRecord returnBook(Long borrowId) {

        BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        Book book = borrowRecord.getBook();

        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        book.setStatus(BookStatus.AVAILABLE);

        bookRepository.save(book);

        borrowRecord.setReturnDate(LocalDate.now());

        if (LocalDate.now().isAfter(borrowRecord.getDueDate())) {

            long overdueDays = ChronoUnit.DAYS.between(
                    borrowRecord.getDueDate(),
                    LocalDate.now()
            );

            borrowRecord.setFineAmount(FineCalculator.calculateFine(overdueDays));
            borrowRecord.setStatus(BorrowStatus.OVERDUE);

        } else {
            borrowRecord.setStatus(BorrowStatus.RETURNED);
        }

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getBorrowHistory(Long userId) {
        return borrowRecordRepository.findByUserUserId(userId);
    }
}