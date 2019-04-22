package com.gmail.zagurskaya.data.repository;

import com.gmail.zagurskaya.data.model.Item;

import java.util.List;

public interface ItemRepository {

    Item add(Item item);

    List<Item> getItems();

    int update(Long id, String status);

}
