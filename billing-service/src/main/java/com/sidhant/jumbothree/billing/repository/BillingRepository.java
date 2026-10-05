package com.sidhant.jumbothree.billing.repository;

import com.sidhant.jumbothree.billing.model.Billing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BillingRepository {

    private final JdbcTemplate jdbcTemplate;

    // Spring automatically injects the configured MySQL DataSource here
    public BillingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper maps the raw database record columns back to our Java Model Object
    private final RowMapper<Billing> rowMapper = (rs, rowNum) -> new Billing(
            rs.getLong("id"),
            rs.getString("invoice_number"),
            rs.getBigDecimal("amount"),
            rs.getString("status")
    );

    // Fetch all invoices using native raw SQL
    public List<Billing> findAllInvoices() {
        String sql = "SELECT id, invoice_number, amount, status FROM billing";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Insert a new billing ledger record
    public int saveInvoice(Billing billing) {
        String sql = "INSERT INTO billing (invoice_number, amount, status) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, billing.getInvoiceNumber(), billing.getAmount(), billing.getStatus());
    }
}