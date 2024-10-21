package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleBtn;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toggleBtn = findViewById(R.id.toggleButton);
        imgView = findViewById(R.id.imageView);

        imgView.setImageDrawable(getResources().getDrawable(R.drawable.light_off));

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleBtn.isChecked()){
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.light_on));
                }else {
                    imgView.setImageDrawable(getResources().getDrawable(R.drawable.light_off));
                }
            }
        });
    }
}