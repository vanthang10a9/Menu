package com.example.menu;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class LoadImageInternet extends AppCompatActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_image_internet);

        mImageView = (ImageView) findViewById(R.id.image);

        Picasso.with(this)
                .load("https://duythanhcse.files.wordpress.com/2018/02/androidcoban_mattruoc.png")
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(mImageView);
    }
}
