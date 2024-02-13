package net.zahaira.accountservice;

import net.zahaira.accountservice.entities.BankAccount;
import net.zahaira.accountservice.enums.AccountTyoe;
import net.zahaira.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
		return args -> {
			BankAccount bankAccount = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(899)
					.createAt(LocalDate.now())
					.type(AccountTyoe.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(89009)
					.createAt(LocalDate.now())
					.type(AccountTyoe.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			bankAccountRepository.save(bankAccount);
			bankAccountRepository.save(bankAccount2);
		};
	}
}
