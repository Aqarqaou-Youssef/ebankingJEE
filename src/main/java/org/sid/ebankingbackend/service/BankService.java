package org.sid.ebankingbackend.service;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("019e477b-161f-4bb0-88da-0d7ce5eea977").orElse(null);
        System.out.println("********************");
        System.out.println(bankAccount.getId());
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getStatus());
        System.out.println(bankAccount.getCreatedAt());
        System.out.println(bankAccount.getCustomer().getName());
        System.out.println(bankAccount.getClass().getSimpleName());//pour avoir le typr de la class
        if(bankAccount instanceof CurrentAccount){
            System.out.println("overdraft ==" +((CurrentAccount)bankAccount).getOverDraft());
        }else if (bankAccount instanceof SavingAccount){
            System.out.println("rate ==" +((SavingAccount)bankAccount).getInterestRate());
        }
        bankAccount.getAccountOperations().forEach(op -> {

            System.out.print(op.getType()+"\t");
            System.out.print(op.getAmount()+"\t");
            System.out.print(op.getOperationDate()+"\t");
        });

    }
}
