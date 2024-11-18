package com.example.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    SharedPreferences SP;
    SharedPreferences.Editor editor;
    EditText edit_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        edit_txt = (EditText) findViewById(R.id.edit_txt);
        SP = getSharedPreferences("file",0);
        editor = SP.edit();
        Intent i = new Intent(this, MainActivity2.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                String s = edit_txt.getText().toString();
                editor.putString("name",s);
                editor.commit();
            }
        });


    }
}
