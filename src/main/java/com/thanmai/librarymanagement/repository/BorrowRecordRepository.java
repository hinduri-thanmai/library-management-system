package com.thanmai.librarymanagement.repository;

import com.thanmai.librarymanagement.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findByUserUserId(Long userId);
}