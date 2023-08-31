package com.example.atmmachine.models;

public class Customer {
    private int id;
    private String customerName;
    private String pin;

    private String accountNumber;

    private String availableBalance;
    private String totalBalance;

    public Customer(int id, String customerName, String accountNumber, String availableBalance, String totalBalance) {
        this.id = id;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }
    public Customer(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }



}
