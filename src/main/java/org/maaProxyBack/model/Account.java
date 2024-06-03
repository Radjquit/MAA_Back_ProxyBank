package org.maaProxyBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    private double balance;
    private LocalDateTime  openingDate = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client2 client;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public Client2 getClient() {
        return client;
    }

    public void setClient(Client2 client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", client=" + client.getId() +
                '}';
    }
}