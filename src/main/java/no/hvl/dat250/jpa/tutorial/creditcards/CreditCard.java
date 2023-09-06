package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;


@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank bank;

    @ManyToMany(mappedBy = "creditCards")
    private Collection<Customer> cardOwners = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer limit) {
        this.creditLimit = limit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    public void setOwningBank(Bank bank) {
        this.bank = bank;
    }

    public Collection<Customer> getOwner() {
        return cardOwners;
    }

    public void setOwner(Customer customer) {
        this.cardOwners.add(customer);
    }
}
