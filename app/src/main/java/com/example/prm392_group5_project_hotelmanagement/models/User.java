package com.example.prm392_group5_project_hotelmanagement.models;

import android.text.TextUtils;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int user_id;

    @ColumnInfo(name = "user_phone")
    private String user_phone;

    @ColumnInfo(name = "user_password")
    private String user_password;

    @ColumnInfo(name = "user_name")
    private String user_name;

    @ColumnInfo(name = "user_image")
    private String user_image;

    @ColumnInfo(name = "user_wallet")
    private double user_wallet;

    @ColumnInfo(name = "user_status")
    private int user_status;

    public User() {
    }

    public User(int user_id, String user_phone, String user_password, String user_name, String user_image, double user_wallet, int user_status) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_image = user_image;
        this.user_wallet = user_wallet;
        this.user_status = user_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public double getUser_wallet() {
        return user_wallet;
    }

    public void setUser_wallet(double user_wallet) {
        this.user_wallet = user_wallet;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public boolean isValidPhone(String phone) {
        return !TextUtils.isEmpty(phone);
    }

    public boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

    public boolean isValidName(String name) {
        return !TextUtils.isEmpty(name);
    }

}
