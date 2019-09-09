package com.example.artikelwayang;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class
AboutActivity extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvName;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle(getString(R.string.about));

        ivPhoto = findViewById(R.id.iv_photo);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);

        Glide.with(getApplicationContext())
                .load(R.drawable.photo)
                .into(ivPhoto);
    }
}


