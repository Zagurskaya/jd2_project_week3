package com.gmail.zagurskaya.web.controller.controller;

import java.util.List;
import javax.validation.Valid;

import com.gmail.zagurskaya.service.model.ItemDTO;
import com.gmail.zagurskaya.service.service.ItemService;
import com.gmail.zagurskaya.web.controller.controller.model.ItemForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        List<ItemDTO> items = itemService.getItems();
        model.addAttribute("items", items);
        logger.debug("Get items method {}", 1);
        return "items";
    }

    @GetMapping("/save")
    public String showForm(ItemForm itemForm) {
        return "form";
    }

    @PostMapping("/save")
    public String checkPersonInfo(
            @Valid ItemForm itemForm,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }

    @GetMapping("/results")
    public String getResult() {
        return "results";
    }
}
