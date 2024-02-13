package net.zahaira.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.zahaira.accountservice.enums.AccountTyoe;
import net.zahaira.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountTyoe type;
    @Transient
    private Customer customer;
    private Long customerId;
}
