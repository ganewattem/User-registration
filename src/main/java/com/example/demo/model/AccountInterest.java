package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Account_Interest")

public class AccountInterest {

    @Id
    @Column(name = "account_no")
    private Long accountNo;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "interest_rate")
    private Integer interestRate;

    @Column(name = "interest")
    private Integer interest;

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "InterestInfo{" +
                "accountNo=" + accountNo +
                ", balance='" + balance + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", interest='" + interest + '\'' +
                '}';
    }
}
