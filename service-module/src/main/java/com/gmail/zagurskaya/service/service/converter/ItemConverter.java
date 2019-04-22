package com.gmail.zagurskaya.service.service.converter;


import com.gmail.zagurskaya.data.model.Item;
import com.gmail.zagurskaya.service.model.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    public Item convertToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setStatus(itemDTO.getStatus());
        return item;
    }

    public ItemDTO convertToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setStatus(item.getStatus());
        return itemDTO;
    }
}
