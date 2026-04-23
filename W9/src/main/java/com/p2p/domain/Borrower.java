package com.p2p.domain;

public class Borrower {

    private static final int CREDIT_SCORE_THRESHOLD = 600;

    private boolean verified;
    private int creditScore;

    public Borrower(boolean verified, int creditScore) {
        this.verified = verified;
        this.creditScore = creditScore;
    }

    public boolean isVerified() { return verified; }
    public int getCreditScore() { return creditScore; }

    // Dipakai TC-01: cek apakah boleh apply loan
    public boolean canApplyLoan() {
        return verified;
    }

    // Dipakai TC-03 & TC-04: cek credit score
    public boolean hasSufficientCreditScore() {
        return creditScore >= CREDIT_SCORE_THRESHOLD;
    }
}