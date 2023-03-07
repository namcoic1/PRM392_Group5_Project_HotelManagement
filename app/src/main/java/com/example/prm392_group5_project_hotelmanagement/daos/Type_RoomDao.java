package com.example.prm392_group5_project_hotelmanagement.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.prm392_group5_project_hotelmanagement.models.Type_Room;

import java.util.List;

@Dao
public interface Type_RoomDao {
    @Query("SELECT * FROM Type_Room")
    List<Type_Room> getAll();
}
