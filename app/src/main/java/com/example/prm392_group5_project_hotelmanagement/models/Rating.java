package com.example.prm392_group5_project_hotelmanagement.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys ={"user_id", "room_id"})
public class Rating {
    private int user_id;

    private int room_id;

    @ColumnInfo(name = "rate")
    private int rate;

    public Rating() {
    }

    public Rating(int user_id, int room_id, int rate) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.rate = rate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
