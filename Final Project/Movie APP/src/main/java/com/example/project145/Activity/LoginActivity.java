package com.example.project145.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project145.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEdt, passwordEdt;
    private MaterialButton loginBtn;
    private TextView registerNowTxt, forgotPasswordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        initView();
    }

    private void initView() {
        // Link views with XML elements
        emailEdt = findViewById(R.id.editTextText);
        passwordEdt = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);
        registerNowTxt = findViewById(R.id.textView5); // Register button (TextView)
        forgotPasswordTxt = findViewById(R.id.textView4); // Forgot password (TextView)

        // Set login button functionality
        loginBtn.setOnClickListener(v -> loginUser());

        // Set register now functionality
        registerNowTxt.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Set forgot password functionality
        forgotPasswordTxt.setOnClickListener(v -> resetPassword());
    }

    private void loginUser() {
        String email = emailEdt.getText().toString().trim();
        String password = passwordEdt.getText().toString().trim();

        // Validate email and password
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate successful login (replace this with real backend logic if needed)
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void resetPassword() {
        String email = emailEdt.getText().toString().trim();

        // Validate email for password reset
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter your email to reset the password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate password reset email sent
        Toast.makeText(this, "Password reset email sent. Check your email!", Toast.LENGTH_SHORT).show();
    }
}
