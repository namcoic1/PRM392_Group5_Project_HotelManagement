package com.example.prm392_group5_project_hotelmanagement.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Order {
    @PrimaryKey(autoGenerate = true)
    private int order_id;

    @ColumnInfo(name = "order_note")
    private String order_note;

    @ColumnInfo(name = "order_checkin")
    private String order_checkin;

    @ColumnInfo(name = "order_checkout")
    private String order_checkout;

    @ColumnInfo(name = "order_created")
    private String order_created;

    @ColumnInfo(name = "order_status")
    private int order_status;

    public Order() {
    }

    public Order(int order_id, String order_note, String order_checkin, String order_checkout, String order_created, int order_status) {
        this.order_id = order_id;
        this.order_note = order_note;
        this.order_checkin = order_checkin;
        this.order_checkout = order_checkout;
        this.order_created = order_created;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public String getOrder_checkin() {
        return order_checkin;
    }

    public void setOrder_checkin(String order_checkin) {
        this.order_checkin = order_checkin;
    }

    public String getOrder_checkout() {
        return order_checkout;
    }

    public void setOrder_checkout(String order_checkout) {
        this.order_checkout = order_checkout;
    }

    public String getOrder_created() {
        return order_created;
    }

    public void setOrder_created(String order_created) {
        this.order_created = order_created;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}

