package com.example.ebankingbackend.services;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        //to search for an account ==>
        BankAccount bankAccount= bankAccountRepository.findById("0a39a0c5-9aaa-4197-91ca-57f95caef627").orElse(null);
        if (bankAccount != null){
            System.out.println("*************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            //just to know the type of the account (saving or current account)
            System.out.println(bankAccount.getClass().getSimpleName());
            if(bankAccount instanceof CurrentAccount){
                System.out.println("over Draft ==>"+((CurrentAccount)bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("interest Rate==> "+((SavingAccount)bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op->{
                System.out.println(op.getType()+"\t"+op.getAmount()+"\t"+op.getOperationDate());
            });
        }else System.out.println("not found********************************************");
    }
}
