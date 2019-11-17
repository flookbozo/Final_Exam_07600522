package com.example.finalexam07600522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam07600522.db.AppDatabase;
import com.example.finalexam07600522.model.registerItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userEditText = findViewById(R.id.username_edit_text);
                EditText passEditText = findViewById(R.id.password_edit_text);

                final String inputUser = userEditText.getText().toString();
                final String inputPass = passEditText.getText().toString();
                if (inputUser.isEmpty() || inputPass.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "All fields are required",
                            Toast.LENGTH_SHORT
                    ).show();
                }
                else {
                    AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                    List<registerItem> itemList = db.registerdao().getAll();
                    for (registerItem item : itemList) {
                        if (inputUser.equals(item.username) && inputPass.equals(item.password)){
                            Toast.makeText(
                                    MainActivity.this,
                                    "Welcome "+item.fullname,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                        else {
                            Toast.makeText(
                                    MainActivity.this,
                                    "Invalid username or password",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
            }
        });

        Button toRegister = findViewById(R.id.register_button);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
