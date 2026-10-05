package com.sidhant.jumbothree.order.repository;

import com.sidhant.jumbothree.order.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Order> rowMapper = (rs, rowNum) -> new Order(
            rs.getLong("id"),
            rs.getString("order_id"),
            rs.getBigDecimal("total_amount")
    );

    // Fetch all orders using plain raw SQL
    public List<Order> findAllOrders() {
        String sql = "SELECT id, order_id, total_amount FROM orders";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Insert a new order record
    public int saveOrder(Order order) {
        String sql = "INSERT INTO orders (order_id, total_amount) VALUES (?, ?)";
        return jdbcTemplate.update(sql, order.getOrderId(), order.getTotalAmount());
    }
}