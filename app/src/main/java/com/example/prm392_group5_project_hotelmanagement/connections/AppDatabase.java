package com.example.prm392_group5_project_hotelmanagement.connections;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.prm392_group5_project_hotelmanagement.daos.OrderDao;
import com.example.prm392_group5_project_hotelmanagement.daos.Order_DetailDao;
import com.example.prm392_group5_project_hotelmanagement.daos.RatingDao;
import com.example.prm392_group5_project_hotelmanagement.daos.Room_HotelDao;
import com.example.prm392_group5_project_hotelmanagement.daos.Type_RoomDao;
import com.example.prm392_group5_project_hotelmanagement.daos.UserDao;
import com.example.prm392_group5_project_hotelmanagement.models.Order;
import com.example.prm392_group5_project_hotelmanagement.models.Order_Detail;
import com.example.prm392_group5_project_hotelmanagement.models.Rating;
import com.example.prm392_group5_project_hotelmanagement.models.Room_Hotel;
import com.example.prm392_group5_project_hotelmanagement.models.Type_Room;
import com.example.prm392_group5_project_hotelmanagement.models.User;

@Database(entities = {Type_Room.class, Room_Hotel.class, User.class, Order.class, Order_Detail.class, Rating.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Booking_Hotel_DB";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract Type_RoomDao type_roomDao();

    public abstract Room_HotelDao room_hotelDao();

    public abstract UserDao userDao();

    public abstract OrderDao orderDao();

    public abstract Order_DetailDao order_detailDao();

    public abstract RatingDao ratingDao();

}