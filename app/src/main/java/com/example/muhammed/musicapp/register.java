package com.example.muhammed.musicapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText gmailEdit,registerUser,registerPass,registerAgainPass;
    Button loginGecis;
    TextView registerText;
    final DatabaseHelper db = new DatabaseHelper(this);

    public void init(){

        gmailEdit = findViewById(R.id.gmailEdit);
        registerUser = findViewById(R.id.registerUser);
        registerPass = findViewById(R.id.registerPassword);
        loginGecis = findViewById(R.id.loginGecis);
        registerText = findViewById(R.id.registerText);
        registerAgainPass = findViewById(R.id.registerAgainPassword);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/CollegiateFLF.ttf");
        registerText.setTypeface(typeface);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        loginGecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = registerUser.getText().toString().trim();
                String pwd = registerPass.getText().toString().trim();
                String conf_pwd = registerAgainPass.getText().toString().trim();
                if (pwd.equals(conf_pwd)){  //girilen sifrelerin ayni olup olmadigini kontrol ediyor.
                    db.AddUser(user,pwd);  //girilen kullanici adi ve parolayi veritabanina ekliyor.
                    Toast.makeText(register.this, "Kayit Islemi Gerceklesti", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(register.this, "Kayit Islemi Basarisiz!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
