package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    private Button mButtonLoadImageIternet;
    private Button mButtonRandom;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonRandom = (Button) findViewById(R.id.button);
        mButtonLoadImageIternet = (Button) findViewById(R.id.buttonLoadImageInternet);

        mButtonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,Random.class);
                MainActivity.this.startActivity(intent);
            }
        });

        mButtonLoadImageIternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, LoadImageInternet.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
