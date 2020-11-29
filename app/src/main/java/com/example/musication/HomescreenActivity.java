package com.example.musication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomescreenActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
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
                if (!isInside(notificationBtn, event)) {
                    notificationBtn.setImageResource(R.drawable.notification);
                }
                return false;
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationBtn.setImageResource(R.drawable.notification);
                startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
            }
        });
        
        chatBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                chatBtn.setImageResource(R.drawable.chat_clicked);
                if (!isInside(chatBtn, event)) {
                    chatBtn.setImageResource(R.drawable.chat);
                }
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
                if (!isInside(profileBtn, event)) {
                    profileBtn.setImageResource(R.drawable.profile);
                }
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
                if (!isInside(calendarBtn, event)) {
                    calendarBtn.setImageResource(R.drawable.calendar);
                }
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
                if (!isInside(bandsBtn, event)) {
                    bandsBtn.setImageResource(R.drawable.bands);
                }
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
                if (!isInside(musicBtn, event)) {
                    musicBtn.setImageResource(R.drawable.music);
                }
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
                if (!isInside(friendsBtn, event)) {
                    friendsBtn.setImageResource(R.drawable.friends);
                }
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
                if (!isInside(settingsBtn, event)) {
                    settingsBtn.setImageResource(R.drawable.settings);
                }
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

        signoutBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                signoutBtn.setImageResource(R.drawable.signout_btn_clicked);
                if (!isInside(signoutBtn, event)) {
                    signoutBtn.setImageResource(R.drawable.signout_btn);
                }
                return false;
            }
        });



        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signoutBtn.setImageResource(R.drawable.signout_btn);
                fAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


    }
    private boolean isInside(View v, MotionEvent e) {
        return !(e.getX() < 0 || e.getY() < 0 || e.getX() > v.getMeasuredWidth() || e.getY() > v.getMeasuredHeight());
    }


}