package net.zahaira.accountservice.web;

import lombok.AllArgsConstructor;
import net.zahaira.accountservice.clients.CustomerRestClient;
import net.zahaira.accountservice.entities.BankAccount;
import net.zahaira.accountservice.model.Customer;
import net.zahaira.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach((acc)->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return bankAccountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount accountList(@PathVariable String id){

        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
