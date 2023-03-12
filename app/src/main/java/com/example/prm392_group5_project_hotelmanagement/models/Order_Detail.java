package com.example.prm392_group5_project_hotelmanagement.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Order_Detail {

    @PrimaryKey(autoGenerate = true)
    private int detail_id;

    @ColumnInfo(name = "detail_price")
    private double detail_price;

    @ColumnInfo(name = "detail_count")
    private int detail_count;

    @ColumnInfo(name = "room_id")
    private int room_id;

    @ColumnInfo(name = "order_id")
    private int order_id;

    public Order_Detail() {
    }

    public Order_Detail(int detail_id, double detail_price, int detail_count, int room_id, int order_id) {
        this.detail_id = detail_id;
        this.detail_price = detail_price;
        this.detail_count = detail_count;
        this.room_id = room_id;
        this.order_id = order_id;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public double getDetail_price() {
        return detail_price;
    }

    public void setDetail_price(double detail_price) {
        this.detail_price = detail_price;
    }

    public int getDetail_count() {
        return detail_count;
    }

    public void setDetail_count(int detail_count) {
        this.detail_count = detail_count;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

}
