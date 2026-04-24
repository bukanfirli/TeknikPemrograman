package com.p2p.service;

import com.p2p.domain.*;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {

    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        logger.info("Start creating loan");

        // =========================
        // VALIDASI (delegasi ke domain)
        // =========================
        validateBorrower(borrower);
        validateAmount(amount);

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        if (borrower.getCreditScore() >= 600) {
            logger.info("Loan APPROVED");
            loan.approve();
        } else {
            logger.warn("Loan REJECTED");
            loan.reject();
        }

        return loan;
    }

    // =========================
    // PRIVATE VALIDATION METHOD
    // =========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower not verified");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Invalid amount");
            throw new IllegalArgumentException("Invalid loan amount");
        }
    }
}