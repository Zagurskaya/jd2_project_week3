package com.gmail.zagurskaya.service.service;

import com.gmail.zagurskaya.service.model.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO add(ItemDTO itemDTO);

    List<ItemDTO> getItems();

    int update(Long id, String status);
}
