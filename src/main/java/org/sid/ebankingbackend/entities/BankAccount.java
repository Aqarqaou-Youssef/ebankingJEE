package org.sid.ebankingbackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.AccountStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE) //cest pour l'heritage
@DiscriminatorColumn (name = "TYPE",length = 4) //ca cest pour specifier cette column par ce que une column type va etres ajouter dans la table
@Data //getters et setters
@NoArgsConstructor
@AllArgsConstructor

public class BankAccount {
    @Id
    private  String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount") //forieng key comme referenses
    private List<AccountOperation> accountOperations;
}
