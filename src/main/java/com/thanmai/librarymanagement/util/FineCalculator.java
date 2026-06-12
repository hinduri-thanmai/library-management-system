package com.thanmai.librarymanagement.util;

public class FineCalculator {

    public static double calculateFine(long overdueDays) {
        return overdueDays * 10.0;
    }
}