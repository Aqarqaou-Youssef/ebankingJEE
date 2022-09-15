package com.example.ebankingbackend.dtos;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.enumes.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
public class AccountOperationDTO {
        private Long id;
        private Date operationDate;
        private double amount;
        private String description;
        private OperationType type;

}