package com.example.prm392_group5_project_hotelmanagement.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Room_Hotel {
    @PrimaryKey(autoGenerate = true)
    private int room_id;

    @ColumnInfo(name = "room_name")
    private String room_name;

    @ColumnInfo(name = "room_image")
    private String room_image;

    @ColumnInfo(name = "room_bed")
    private int room_bed;

    @ColumnInfo(name = "room_price")
    private double room_price;

    @ColumnInfo(name = "room_status")
    private int room_status;

    @ColumnInfo(name = "type_id")
    private int type_id;

    public Room_Hotel() {
    }

    public Room_Hotel(int room_id, String room_name, String room_image, int room_bed, double room_price, int room_status, int type_id) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_image = room_image;
        this.room_bed = room_bed;
        this.room_price = room_price;
        this.room_status = room_status;
        this.type_id = type_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_image() {
        return room_image;
    }

    public void setRoom_image(String room_image) {
        this.room_image = room_image;
    }

    public int getRoom_bed() {
        return room_bed;
    }

    public void setRoom_bed(int room_bed) {
        this.room_bed = room_bed;
    }

    public double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }

    public int getRoom_status() {
        return room_status;
    }

    public void setRoom_status(int room_status) {
        this.room_status = room_status;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
