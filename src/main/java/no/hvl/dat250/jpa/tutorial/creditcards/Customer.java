package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Collection<Address> addresses = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "customer_creditcard",
            joinColumns = @JoinColumn(name = "customer_fk"),
            inverseJoinColumns = @JoinColumn(name = "creditcard_fk"))
    private Collection<CreditCard> creditCards = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

}
