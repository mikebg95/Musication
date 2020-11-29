package com.example.musication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;

    ImageView googleLogin, fbLogin, instaLogin, loginBtn, forgotPassword, registerLink;
    EditText emailEntry, passwordEntry;
    TextView emailErrorLogin, passwordErrorLogin;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser user = fAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();

        googleLogin = findViewById(R.id.google_login);
        fbLogin = findViewById(R.id.fb_login);
        instaLogin = findViewById(R.id.insta_login);
        loginBtn = findViewById(R.id.login_btn);
        forgotPassword = findViewById(R.id.forgot_password);

        emailEntry = findViewById(R.id.email_entry);
        passwordEntry = findViewById(R.id.password_entry);

        emailErrorLogin = findViewById(R.id.email_error_login);
        passwordErrorLogin = findViewById(R.id.password_error_login);

        registerLink = findViewById(R.id.register_link);

        forgotPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                forgotPassword.setImageResource(R.drawable.forgot_password_clicked);
                if (!isInside(forgotPassword, event)) {
                    forgotPassword.setImageResource(R.drawable.forgot_password);
                }
                return false;
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword.setImageResource(R.drawable.forgot_password);
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
            }
        });


        emailEntry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String email = emailEntry.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(email)) {
                        emailEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        emailEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        emailErrorLogin.setText("Email address is required");
                    }
                    else {
                        emailEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        emailEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        emailErrorLogin.setText("");
                    }
                }
            }
        });

        passwordEntry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = passwordEntry.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(password)) {
                        passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        passwordEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                        passwordErrorLogin.setText("Password is required");
                    }
                    else {
                        passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                        passwordErrorLogin.setText("");
                    }
                }
            }
        });

        registerLink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                registerLink.setImageResource(R.drawable.register_link_clicked);
                if (!isInside(registerLink, event)) {
                    registerLink.setImageResource(R.drawable.register_link);
                }
                return false;
            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerLink.setImageResource(R.drawable.register_link);
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        loginBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                loginBtn.setImageResource(R.drawable.login_btn_clicked);
                if (!isInside(loginBtn, event)) {
                    loginBtn.setImageResource(R.drawable.login_btn);
                }
                return false;
            }
        });




        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn.setImageResource(R.drawable.login_btn);

                boolean ready = true;

                String email = emailEntry.getText().toString().trim();
                String password = passwordEntry.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    emailEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    emailEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    emailErrorLogin.setText("Email address is required");
                    ready = false;
                }

                if (TextUtils.isEmpty(password)) {
                    passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    passwordEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.error_circle, 0);
                    passwordErrorLogin.setText("Password is required");
                    ready = false;
                }

                if (ready) {
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                makeToast("successfully logged in");
                                startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
                            }
                            else {
                                makeToast("log in failed");
                                makeToast("Error: " + task.getException().getMessage());
                            }
                        }
                    });
                }
            }
        });

//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
//            }
//        });
    }

    public void makeToast(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean isInside(View v, MotionEvent e) {
        return !(e.getX() < 0 || e.getY() < 0 || e.getX() > v.getMeasuredWidth() || e.getY() > v.getMeasuredHeight());
    }
}