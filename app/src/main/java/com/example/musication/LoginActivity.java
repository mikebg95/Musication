package com.example.musication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    EditText usernameEntry, passwordEntry;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser user = fAuth.getCurrentUser();
        if (user != null) {
//            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
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

        usernameEntry = findViewById(R.id.username_entry);
        passwordEntry = findViewById(R.id.password_entry);

        registerLink = findViewById(R.id.register_link);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        usernameEntry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String username = usernameEntry.getText().toString().trim();
                if (!hasFocus) {
                    if (TextUtils.isEmpty(username)) {
                        usernameEntry.setError("Username is required");
                    }
                    else {
                        usernameEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        usernameEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
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
                        passwordEntry.setError("Password is required");
                    }
                    else {
                        passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        passwordEntry.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_circle, 0);
                    }
                }
            }
        });

//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean ready = true;
//
//                String username = usernameEntry.getText().toString().trim();
//                String password = usernameEntry.getText().toString().trim();
//
//                if (TextUtils.isEmpty(username)) {
//                    usernameEntry.setError("Username is required");
//                    ready = false;
//                }
//
//                if (TextUtils.isEmpty(password)) {
//                    passwordEntry.setError("Password is required");
//                    ready = false;
//                }
//
//                if (ready) {
//                    fAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                makeToast("successfully logged in");
//                                startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
//                            }
//                            else {
//                                makeToast("log in failed");
//                            }
//                        }
//                    });
//                }
//            }
//        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
            }
        });
    }

    public void makeToast(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }
}