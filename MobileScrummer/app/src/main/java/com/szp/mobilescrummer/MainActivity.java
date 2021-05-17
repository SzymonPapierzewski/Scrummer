package com.szp.mobilescrummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.szp.mobilescrummer.ui.register.RegisterActivity;
import com.szp.mobilescrummer.ui.taskCreator.TaskCreatorActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigateToAdd = findViewById(R.id.activity_main_add_button);
        Button navigateToDisplay = findViewById(R.id.activity_main_display_button);
        Button navigateToRegister = findViewById(R.id.activity_main_register_button);

        navigateToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskCreatorActivity.class);
                startActivity(intent);
            }
        });

        navigateToDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskCreatorActivity.class);
                startActivity(intent);
            }
        });

        navigateToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
