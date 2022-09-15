package com.example.ebankingbackend.entities;

import com.example.ebankingbackend.enumes.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date operationDate;
        private double amount;
        private String description;
        @Enumerated(EnumType.STRING)
        private OperationType type;
        @ManyToOne
        private BankAccount bankAccount;
}
