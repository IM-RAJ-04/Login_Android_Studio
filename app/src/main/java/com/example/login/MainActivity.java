package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Assigning views
        EditText usernameEditText = findViewById(R.id.edt1);
        EditText passwordEditText = findViewById(R.id.edt2);
        Button loginButton = findViewById(R.id.btn1);

        // Adding click listener to login button
        loginButton.setOnClickListener(v -> {
            // Get the username and password entered by the user
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Check if username and password are correct
            if (username.equals("Amir") && password.equals("Sinus")) {
                // If correct, start the second activity and pass the username
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
            else if (username.equals("Senn") && password.equals("Coding")) {
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            } else {
                // If incorrect, show a toast message
                Toast.makeText(MainActivity.this, "Username atau Password Salah !!!", Toast.LENGTH_SHORT).show();
            }
        });

        // Add insets listener to adjust padding when system bars change
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

