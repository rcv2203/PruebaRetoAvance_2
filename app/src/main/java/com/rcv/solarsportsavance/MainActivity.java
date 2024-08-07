package com.rcv.solarsportsavance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button, btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_sign_in);
        btn_signUp = findViewById(R.id.btn_sign_up);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Puedes ingresare", Toast.LENGTH_SHORT).show();
            }
        });
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_up = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent_up);
                Toast.makeText(getApplicationContext(),"Estas en registrarse", Toast.LENGTH_SHORT).show();
            }
        });
    }
}