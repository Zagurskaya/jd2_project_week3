package com.gmail.zagurskaya.service.service.impl;

import com.gmail.zagurskaya.data.model.Item;
import com.gmail.zagurskaya.data.repository.ItemRepository;
import com.gmail.zagurskaya.service.service.ItemService;
import com.gmail.zagurskaya.service.service.converter.ItemConverter;
import com.gmail.zagurskaya.service.model.ItemDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);

    private ItemRepository itemRepository;

    private ItemConverter itemConverter;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setItemConverter(ItemConverter itemConverter) {
        this.itemConverter = itemConverter;
    }

    @Override
    public ItemDTO add(ItemDTO itemDTO) {
        Item item = itemConverter.convertToEntity(itemDTO);

        Item added = itemRepository.add(item);

        return itemConverter.convertToDTO(added);
    }


    @Override
    public List<ItemDTO> getItems() {
        List<Item> itemList = itemRepository.getItems();

        List<ItemDTO> itemDTOList = itemList.stream().map(item -> itemConverter.convertToDTO(item)).collect(Collectors.toList());

        return itemDTOList;
    }

    @Override
    public int update(Long id, String status) {
        return itemRepository.update(id, status);
    }
}
