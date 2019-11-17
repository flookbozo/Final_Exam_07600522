package com.example.finalexam07600522;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam07600522.db.RegisterRepository;
import com.example.finalexam07600522.model.registerItem;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button RegisButton = findViewById(R.id.register_button);
        RegisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText fullnameEdit = findViewById(R.id.full_name_edit_text);
                String fullname = fullnameEdit.getText().toString();

                EditText userEdit = findViewById(R.id.username_edit_text);
                String user = userEdit.getText().toString();

                EditText passEdit = findViewById(R.id.password_edit_text);
                String pass = passEdit.getText().toString();

                if (fullname.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(
                            RegisterActivity.this,
                            "All fields are required",
                            Toast.LENGTH_SHORT
                    ).show();
                }
                else {
                    registerItem item = new registerItem(fullname, user, pass);

                    RegisterRepository repo = new RegisterRepository(RegisterActivity.this);
                    repo.insertRegister(item, new RegisterRepository.InsertCallback() {
                        @Override
                        public void onInsertSuccess() {
                            Toast.makeText(
                                    RegisterActivity.this,
                                    "Register successfully",
                                    Toast.LENGTH_SHORT
                            ).show();
                            finish();
                        }
                    });
                }
            }
        });


    }
}
