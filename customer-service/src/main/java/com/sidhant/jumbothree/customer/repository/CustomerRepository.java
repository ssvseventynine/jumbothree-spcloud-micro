package com.sidhant.jumbothree.customer.repository;

import com.sidhant.jumbothree.customer.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Customer> rowMapper = (rs, rowNum) -> new Customer(
            rs.getLong("id"),
            rs.getString("customer_id"),
            rs.getString("name"),
            rs.getString("email")
    );

    // Fetch all customers using raw SQL
    public List<Customer> findAllCustomers() {
        String sql = "SELECT id, customer_id, name, email FROM customers";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Insert a new customer record
    public int saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customer_id, name, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getCustomerId(), customer.getName(), customer.getEmail());
    }
}