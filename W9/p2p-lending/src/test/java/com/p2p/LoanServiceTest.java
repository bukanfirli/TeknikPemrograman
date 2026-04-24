package com.p2p;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    private static final Logger log = LogManager.getLogger(LoanServiceTest.class);

    //TC-01
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        log.info("TC-01: Borrower tidak terverifikasi");

        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        });

        log.info("TC-01: Exception berhasil terjadi");
    }

    //TC-02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        log.info("TC-02: Amount tidak valid");

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(0));
        });

        log.info("TC-02: Exception berhasil terjadi");
    }

    //TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        log.info("TC-03: Credit score tinggi");

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.APPROVED, loan.getStatus());

        log.info("TC-03: Loan APPROVED");
    }

    //TC-04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        log.info("TC-04: Credit score rendah");

        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();

        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.REJECTED, loan.getStatus());

        log.warn("TC-04: Loan REJECTED");
    }
}