package com.example.finalexam07600522.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "register")
public class registerItem {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "fullname")
    public String fullname;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public registerItem(String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }
}
