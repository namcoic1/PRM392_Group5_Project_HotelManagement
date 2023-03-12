package com.example.prm392_group5_project_hotelmanagement.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Type_Room {
    @PrimaryKey(autoGenerate = true)
    private int type_id;

    @ColumnInfo(name = "type_name")
    private String type_name;

    @ColumnInfo(name = "type_image")
    private String type_image;

    @ColumnInfo(name = "type_desc")
    private String type_desc;

    @ColumnInfo(name = "type_status")
    private int type_status;

    public Type_Room() {
    }

    public Type_Room(int type_id, String type_name, String type_image, String type_desc, int type_status) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_image = type_image;
        this.type_desc = type_desc;
        this.type_status = type_status;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_image() {
        return type_image;
    }

    public void setType_image(String type_image) {
        this.type_image = type_image;
    }

    public String getType_desc() {
        return type_desc;
    }

    public void setType_desc(String type_desc) {
        this.type_desc = type_desc;
    }

    public int getType_status() {
        return type_status;
    }

    public void setType_status(int type_status) {
        this.type_status = type_status;
    }
}
