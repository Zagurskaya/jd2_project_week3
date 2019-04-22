package com.gmail.zagurskaya.data.repository.impl;

import com.gmail.zagurskaya.data.exception.DatabaseException;
import com.gmail.zagurskaya.data.model.AuditItem;
import com.gmail.zagurskaya.data.model.Item;
import com.gmail.zagurskaya.data.repository.AuditItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditItemRepositoryImpl implements AuditItemRepository {

    private static final Logger logger = LogManager.getLogger(AuditItemRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public AuditItem save(AuditItem auditItem) {
        String sql = String.format("INSERT INTO `auditItem`(`id`, `action`, `item_id`, `date`) VALUES ('%s','%s','%s','%s')",
                auditItem.getId(), auditItem.getAction(), auditItem.getItem_id(), auditItem.getDate());

        long documentId = jdbcTemplate.queryForObject(sql, Long.class);
        if (documentId > 0) {
            auditItem.setId(documentId);
            return auditItem;
        } else {
            logger.error("auditItem not added");
            throw new DatabaseException("Database exception during save auditItem");
        }
    }
}
