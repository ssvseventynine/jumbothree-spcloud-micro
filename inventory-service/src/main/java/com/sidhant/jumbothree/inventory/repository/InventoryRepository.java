package com.sidhant.jumbothree.inventory.repository;

import com.sidhant.jumbothree.inventory.model.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InventoryRepository {

    private final JdbcTemplate jdbcTemplate;

    // Spring automatically injects the configured MySQL DataSource here
    public InventoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper acts as the bridge converting a MySQL database row into our Java Model Object
    private final RowMapper<Inventory> rowMapper = (rs, rowNum) -> new Inventory(
            rs.getLong("id"),
            rs.getString("item_code"),
            rs.getInt("stock_level")
    );

    // Fetch all stock rows using a plain raw SQL string
    public List<Inventory> findAllItems() {
        String sql = "SELECT id, item_code, stock_level FROM inventory";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Insert a new item into our database schema
    public int saveItem(Inventory item) {
        String sql = "INSERT INTO inventory (item_code, stock_level) VALUES (?, ?)";
        return jdbcTemplate.update(sql, item.getItemCode(), item.getStockLevel());
    }
}