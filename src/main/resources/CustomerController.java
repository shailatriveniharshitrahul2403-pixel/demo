package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    // 1. READ ALL (GET http://localhost:8081/customers)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // 2. CREATE NEW (POST http://localhost:8081/customers)
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    // 3. UPDATE EXISTING (PUT http://localhost:8081/customers/1)
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedData) {
        return repository.findById(id).map(customer -> {
            customer.setCustomerName(updatedData.getCustomerName());
            customer.setCity(updatedData.getCity());
            return repository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // 4. DELETE BY ID (DELETE http://localhost:8081/customers/1)
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Customer deleted with ID: " + id;
    }
}
