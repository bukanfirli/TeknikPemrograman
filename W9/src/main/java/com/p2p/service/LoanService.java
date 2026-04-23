package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import java.math.BigDecimal;

public class LoanService {

    private static final int CREDIT_SCORE_THRESHOLD = 600;

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // TC-01: cek borrower
        validateBorrower(borrower);

        // TC-02: cek amount
        validateAmount(amount);

        // TC-03 & TC-04: credit scoring
        Loan loan = new Loan();
        if (borrower.hasSufficientCreditScore()) {
            loan.approve();
        } else {
            loan.reject();
        }

        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
    }
}