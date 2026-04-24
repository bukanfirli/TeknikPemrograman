package com.p2p;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    //TC-01
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan exception
        // =====================================================

        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        });
    }

    //TC-02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        // Borrower valid tapi amount tidak valid
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(0));
        });
    }

    //TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        // Borrower valid dan credit score tinggi
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    //TC-04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        // Borrower valid tapi credit score rendah
        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();

        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}