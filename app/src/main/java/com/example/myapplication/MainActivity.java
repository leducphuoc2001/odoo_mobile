package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.Handle.ImageUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    public static int uid;
    public static String db, url, user, pass, name, email, image;
    private TextView txtDisplayName, txtEmail;
    private ImageView imgAvatar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        getIntentSignIn();
    }
    public final void getIntentSignIn() {
        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", -1);
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        image = intent.getStringExtra("image");
        db = intent.getStringExtra("db");
        url = intent.getStringExtra("url");
        user = intent.getStringExtra("user");
        pass = intent.getStringExtra("pass");
        if (name != null && email != null && image != null) {
            txtEmail.setText(email);
            txtDisplayName.setText(name);
            imgAvatar.setImageBitmap(ImageUtils.getBitmapImage(image));
        }
    }
    private void mapping() {
        navigationView = findViewById(R.id.nav_view);
        txtEmail = navigationView.getHeaderView(0).findViewById(R.id.txtEmail);
        imgAvatar = navigationView.getHeaderView(0).findViewById(R.id.imgAvatar);
        txtDisplayName = navigationView.getHeaderView(0).findViewById(R.id.txtName);
    }
}