package com.gmail.zagurskaya.data.repository.impl;

import com.gmail.zagurskaya.data.exception.DatabaseException;
import com.gmail.zagurskaya.data.model.Item;
import com.gmail.zagurskaya.data.repository.ItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private static final Logger logger = LogManager.getLogger(ItemRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Item add(Item item) {
        String sql = String.format("INSERT INTO `item`(`name`, `status`) VALUES ('%s','%s')",
                item.getName(), item.getStatus());

        long documentId = jdbcTemplate.queryForObject(sql, Long.class);
        if (documentId > 0) {
            item.setId(documentId);
            return item;
        } else {
            logger.error("item not added");
            throw new DatabaseException("Database exception during save item");
        }
    }

    @Override
    public int update(Long id, String status) {
        String sql = String.format(
                "UPDATE `item` SET `status`='%s' WHERE `id`='%d'",
                status, id);
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    @Override
    public List<Item> getItems() {
        return getAll("");
    }

    private List<Item> getAll(String where) {
        String sql = String.format(
                "SELECT * FROM `item` " + where);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return rows.stream()
                .map(row -> {
                    Item item = new Item();
                    item.setId((Long) row.get("id"));
                    item.setName((String) row.get("name"));
                    item.setStatus((String) row.get("status"));
                    return item;
                }).collect(Collectors.toList());
    }
}
