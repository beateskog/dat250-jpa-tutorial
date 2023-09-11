package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> ownedCards = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @CollectionTable
    public void addCard(CreditCard card) {
        this.ownedCards.add(card);
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }
}
