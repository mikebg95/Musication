package com.example.musication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth fAuth;

    ImageView googleRegister, fbRegister, instaRegister, registerBtn, loginLink;
    EditText firstNameRegister, lastNameRegister, emailRegister, passwordRegister, password2Register;
    TextView firstNameErrorRegister, lastNameErrorRegister, emailErrorRegister, passwordErrorRegister, password2ErrorRegister;

    Drawable error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();

        googleRegister = findViewById(R.id.google_register);
        fbRegister = findViewById(R.id.fb_register);
        instaRegister = findViewById(R.id.insta_register);

        registerBtn = findViewById(R.id.register_btn);
        loginLink = findViewById(R.id.login_link);

        firstNameRegister = findViewById(R.id.first_name_register);
        lastNameRegister = findViewById(R.id.last_name_register);
        emailRegister = findViewById(R.id.email_register);
        passwordRegister = findViewById(R.id.password_register);
        password2Register = findViewById(R.id.password2_register);

        firstNameErrorRegister = findViewById(R.id.first_name_error_register);
        lastNameErrorRegister = findViewById(R.id.last_name_error_register);
        emailErrorRegister = findViewById(R.id.email_error_register);
        passwordErrorRegister = findViewById(R.id.password_error_register);
        password2ErrorRegister = findViewById(R.id.password2_error_register);

        error = getResources().getDrawable(R.drawable.error_circle);

        // automatically goes to homepage screen cause previous user is always logged in
//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
//            finish();
//        }

        firstNameRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String firstName = firstNameRegister.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(firstName)) {
                        firstNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        firstNameRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        firstNameErrorRegister.setText("Username is required");
                    }
                    else {
                        firstNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        firstNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        firstNameErrorRegister.setText("");
                    }
                }
            }
        });

        lastNameRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String lastName = lastNameRegister.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(lastName)) {
                        lastNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        lastNameRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        lastNameErrorRegister.setText("Last name is required");
                    }
                    else {
                        lastNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        lastNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        lastNameErrorRegister.setText("");
                    }
                }
            }
        });

        emailRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String email = emailRegister.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(email)) {
                        emailRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        emailRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        emailErrorRegister.setText("Email address is required");
                    }
                    else {
                        emailRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        emailRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        emailErrorRegister.setText("");
                    }
                }
            }
        });

        passwordRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = passwordRegister.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(password)) {
                        passwordRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        passwordRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        passwordErrorRegister.setText("Password is required");
                    }
                    else {
                        passwordRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        passwordRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        passwordErrorRegister.setText("");
                    }
                }
            }
        });

        password2Register.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password2 = password2Register.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(password2)) {
                        password2Register.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        password2Register.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        password2ErrorRegister.setText("Password confirmation is required");
                    }
                    else {
                        password2Register.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        password2Register.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        password2Register.setText("");
                    }
                }
            }
        });

        registerBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                registerBtn.setImageResource(R.drawable.register_btn_clicked);
                if (!isInside(registerBtn, event)) {
                    registerBtn.setImageResource(R.drawable.signup_btn);
                }
                return false;
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerBtn.setImageResource(R.drawable.signup_btn);

                boolean ready = true;
                String firstName = firstNameRegister.getText().toString().trim();
                String lastName = lastNameRegister.getText().toString().trim();
                String email = emailRegister.getText().toString().trim();
                String password = passwordRegister.getText().toString().trim();
                String password2 = password2Register.getText().toString().trim();

                if (TextUtils.isEmpty(firstName)) {
                    firstNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    firstNameRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    firstNameErrorRegister.setText("First name is required");
                    ready = false;
                }
                if (TextUtils.isEmpty(lastName)) {
                    lastNameRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    lastNameRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    lastNameErrorRegister.setText("Last name is required");
                    ready = false;
                }
                if (TextUtils.isEmpty(email)) {
                    emailRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    emailRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    emailErrorRegister.setText("Email address is required");
                    ready = false;
                }
                if (TextUtils.isEmpty(password)) {
                    passwordRegister.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    passwordRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    passwordErrorRegister.setText("Password is required");
                    ready = false;
                }
                if (TextUtils.isEmpty(password2)) {
                    password2Register.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    password2Register.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    password2ErrorRegister.setText("Password confirmation is required");
                    ready = false;
                }
                if (!password.equals(password2)) {
                    password2Register.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    password2Register.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    password2ErrorRegister.setText("Passwords don't match");
                    ready = false;
                }

                if (ready) {
                    createAccount(email, password);
                }
            }
        });

        loginLink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                loginLink.setImageResource(R.drawable.login_link_clicked);
                if (!isInside(loginLink, event)) {
                    loginLink.setImageResource(R.drawable.login_link);
                }
                return false;
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginLink.setImageResource(R.drawable.login_link);
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }

    public void createAccount(String email, String password) {
        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isInside(View v, MotionEvent e) {
        return !(e.getX() < 0 || e.getY() < 0 || e.getX() > v.getMeasuredWidth() || e.getY() > v.getMeasuredHeight());
    }
}