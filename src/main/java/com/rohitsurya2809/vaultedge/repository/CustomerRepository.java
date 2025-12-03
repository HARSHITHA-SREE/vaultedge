package com.rohitsurya2809.vaultedge.repository;

import com.rohitsurya2809.vaultedge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
}
