package net.zahaira.customerservice;

import net.zahaira.customerservice.config.GlobalConfig;
import net.zahaira.customerservice.entities.Customer;
import net.zahaira.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return  args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("sahor")
                            .lastName("oklim")
                            .email("sahoroklim@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("layla")
                            .lastName("wardi")
                            .email("laylawardi@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
