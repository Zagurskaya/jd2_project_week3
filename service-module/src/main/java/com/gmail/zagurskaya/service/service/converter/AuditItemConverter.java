package com.gmail.zagurskaya.service.service.converter;


import com.gmail.zagurskaya.data.model.AuditItem;
import com.gmail.zagurskaya.data.model.Item;
import com.gmail.zagurskaya.service.model.AuditItemDTO;
import com.gmail.zagurskaya.service.model.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class AuditItemConverter {

    public AuditItem convertToEntity(AuditItemDTO auditItemDTO) {
        AuditItem auditItem = new AuditItem();
        auditItem.setId(auditItemDTO.getId());
        auditItem.setAction(auditItemDTO.getAction());
        auditItem.setDate(auditItemDTO.getDate());
        auditItem.setItem_id(auditItemDTO.getItem_id());
        return auditItem;
    }

    public AuditItemDTO convertToDTO(AuditItem auditItem) {
        AuditItemDTO auditItemDTO = new AuditItemDTO();
        auditItemDTO.setId(auditItem.getId());
        auditItemDTO.setAction(auditItem.getAction());
        auditItemDTO.setDate(auditItem.getDate());
        auditItemDTO.setItem_id(auditItem.getItem_id());
        return auditItemDTO;
    }
}
