package com.example.travelapp_630;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton gecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_main);

        gecis = findViewById(R.id.buttonGirisSayfasi);

        ImageView imgLeft = findViewById(R.id.imgLeft);
        ImageView imgRight = findViewById(R.id.imgRight);
        ImageView imgCenter = findViewById(R.id.imgCenter);

        ImageUtils.setSafeImage(imgLeft, R.drawable.oiagreecelandscape);
        ImageUtils.setSafeImage(imgRight, R.drawable.oiagreecelandscape1);
        ImageUtils.setSafeImage(imgCenter, R.drawable.aerialviewoftropicalislands);

        gecis.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivityLogin.class);
            startActivity(intent);
        });
    }
}