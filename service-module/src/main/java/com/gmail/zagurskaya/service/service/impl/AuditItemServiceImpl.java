package com.gmail.zagurskaya.service.service.impl;

import com.gmail.zagurskaya.data.model.AuditItem;
import com.gmail.zagurskaya.data.repository.AuditItemRepository;
import com.gmail.zagurskaya.service.model.AuditItemDTO;
import com.gmail.zagurskaya.service.service.AuditItemService;
import com.gmail.zagurskaya.service.service.converter.AuditItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditItemServiceImpl implements AuditItemService {

    private AuditItemRepository auditItemRepository;

    private AuditItemConverter auditItemConverter;

    @Autowired
    public void setAuditItemRepository(AuditItemRepository auditItemRepository) {
        this.auditItemRepository = auditItemRepository;
    }

    @Autowired
    public void setAuditItemConverter(AuditItemConverter auditItemConverter) {
        this.auditItemConverter = auditItemConverter;
    }

    @Override
    public AuditItemDTO save(AuditItemDTO auditItemDTO) {
        AuditItem auditItem = auditItemConverter.convertToEntity(auditItemDTO);

        AuditItem savedAuditItem = auditItemRepository.save(auditItem);

        return auditItemConverter.convertToDTO(savedAuditItem);
    }

}
