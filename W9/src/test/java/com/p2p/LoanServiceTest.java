package com.p2p;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class LoanServiceTest {

    // TC-01
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    // TC-02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-500));
        });
    }

    // TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertNotNull(loan);
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    // TC-04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        Borrower borrower = new Borrower(true, 400);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertNotNull(loan);
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}