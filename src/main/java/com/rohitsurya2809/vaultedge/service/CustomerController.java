package com.rohitsurya2809.vaultedge.service;

import java.util.Map;
import com.rohitsurya2809.vaultedge.dto.RegisterRequest;
import com.rohitsurya2809.vaultedge.dto.CustomerResponse;
import com.rohitsurya2809.vaultedge.model.Customer;
import com.rohitsurya2809.vaultedge.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        Customer c = service.register(req);
        return ResponseEntity.status(201).body(MapOf(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        Customer c = service.getById(id);
        return ResponseEntity.ok(MapOf(c));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<Customer> customers = service.listAll();
        var resp = customers.stream().map(this::toResp).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody RegisterRequest req) {
        Customer updated = service.update(id, req);
        return ResponseEntity.ok(MapOf(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerResponse toResp(Customer c) {
        return CustomerResponse.builder()
                .id(c.getId().toString())
                .fullName(c.getFullName())
                .email(c.getEmail())
                .phone(c.getPhone())
                .address(c.getAddress())
                .build();
    }

    private Map<String, Object> MapOf(Customer c) {
        return Map.of("data", toResp(c));
    }
}

