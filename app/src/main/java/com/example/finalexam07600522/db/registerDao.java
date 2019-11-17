package com.example.finalexam07600522.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.finalexam07600522.model.registerItem;

import java.util.List;

@Dao
public interface registerDao {

    @Query("SELECT * FROM register")
    List<registerItem> getAll();

    @Insert
    void insert(registerItem registeritem);
}
