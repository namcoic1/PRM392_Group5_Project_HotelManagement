package com.example.prm392_group5_project_hotelmanagement.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.prm392_group5_project_hotelmanagement.models.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE user_phone LIKE :phone AND user_password LIKE :password")
    User checkLogin(String phone, String password);

    @Query("INSERT INTO User VALUES (null, :phone, :password, :name, null, 0, 1)")
    void register(String phone, String password, String name);
}
