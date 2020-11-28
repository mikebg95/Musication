package com.example.musication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class HomescreenActivity extends AppCompatActivity {

    ImageView notificationBtn, chatBtn, profileBtn, calendarBtn, bandsBtn, musicBtn, friendsBtn, settingsBtn, signoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        notificationBtn = findViewById(R.id.notification_btn);
        chatBtn = findViewById(R.id.chat_btn);
        profileBtn = findViewById(R.id.profile_btn);
        calendarBtn = findViewById(R.id.calendar_btn);
        bandsBtn = findViewById(R.id.bands_btn);
        musicBtn = findViewById(R.id.music_btn);
        friendsBtn = findViewById(R.id.friends_btn);
        settingsBtn = findViewById(R.id.settings_btn);
        signoutBtn = findViewById(R.id.signout_btn);

        // TODO: when holding & swiping (not clicking), button keeps showing clicked button
        notificationBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                notificationBtn.setImageResource(R.drawable.notification_clicked);
                if (event.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                    notificationBtn.setImageResource(R.drawable.notification);
                }
                return false;
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
            }
        });
        
        chatBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                chatBtn.setImageResource(R.drawable.chat_clicked);
                return false;
            }
        });

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatBtn.setImageResource(R.drawable.chat);
                startActivity(new Intent(getApplicationContext(), ChatActivity.class));
            }
        });

        profileBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileBtn.setImageResource(R.drawable.profile_clicked);
                return false;
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileBtn.setImageResource(R.drawable.profile);
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));

            }
        });



        calendarBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                calendarBtn.setImageResource(R.drawable.calendar_clicked);
                return false;
            }
        });

        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarBtn.setImageResource(R.drawable.calendar);
                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));

            }
        });


        bandsBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bandsBtn.setImageResource(R.drawable.bands_clicked);
                return false;
            }
        });

        bandsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bandsBtn.setImageResource(R.drawable.bands);
                startActivity(new Intent(getApplicationContext(), BandsActivity.class));

            }
        });


        musicBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                musicBtn.setImageResource(R.drawable.music_clicked);
                return false;
            }
        });

        musicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicBtn.setImageResource(R.drawable.music);
                startActivity(new Intent(getApplicationContext(), MusicActivity.class));

            }
        });


        friendsBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                friendsBtn.setImageResource(R.drawable.friends_clicked);
                return false;
            }
        });

        friendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendsBtn.setImageResource(R.drawable.friends);
                startActivity(new Intent(getApplicationContext(), FriendsActivity.class));

            }
        });



        settingsBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                settingsBtn.setImageResource(R.drawable.settings_clicked);
                return false;
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsBtn.setImageResource(R.drawable.settings);
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));

            }
        });



        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}