package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data //getters et setters
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private  String email;
    @OneToMany(mappedBy = "customer") //comme forieng key dans BankAccount
    private List<BankAccount> bankAccounts;

}
