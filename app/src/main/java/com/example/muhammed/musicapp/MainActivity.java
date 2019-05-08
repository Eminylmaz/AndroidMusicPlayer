package com.example.muhammed.musicapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button loginBtn,registerBtn;
    TextView loginText;
    final DatabaseHelper db = new DatabaseHelper(this);

    public void init(){

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        View backgroundImage = findViewById(R.id.background); //background opacity ayarlama
        Drawable background = backgroundImage.getBackground();
        background.setAlpha(100);


        loginText = findViewById(R.id.loginText);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/CollegiateFLF.ttf"); //Font tipi ayarlama
        loginText.setTypeface(typeface);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);  //register kisminda eklenmis degerleri checkUser metodu ile dogrulugunu kontrol ediyor
                if (res == true){  //eger kullanici adi ve parola veritabanindaki ile ayniysa if'in icine giriyor.
                    Toast.makeText(MainActivity.this, "Giris Basarili", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),anaekran.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Giris Basarisiz!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
