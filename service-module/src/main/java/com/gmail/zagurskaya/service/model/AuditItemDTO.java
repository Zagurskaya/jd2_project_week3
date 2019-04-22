package com.gmail.zagurskaya.service.model;

import java.sql.Date;

public class AuditItemDTO {

    private Long id;
    private String action;
    private Long item_id;
    private Date date;

    public AuditItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AuditItem{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", item_id=" + item_id +
                ", date=" + date +
                '}';
    }
}
