package com.codingblocks.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User user);

}
