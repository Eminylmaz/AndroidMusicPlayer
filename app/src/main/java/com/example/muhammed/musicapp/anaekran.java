package com.example.muhammed.musicapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class anaekran extends AppCompatActivity {

    TextView txtName;
    Button rock,top100,arabesk,caz,rap,clasic,melankoli,turku;
    ImageView profileImage;

    public void init() {
        rock =(Button) findViewById(R.id.rock);
        top100 =(Button) findViewById(R.id.top100);
        arabesk =(Button) findViewById(R.id.arabesk);
        caz =(Button) findViewById(R.id.caz);
        rap =(Button) findViewById(R.id.rap);
        clasic =(Button) findViewById(R.id.clasic);
        melankoli =(Button) findViewById(R.id.melankoli);
        turku =(Button) findViewById(R.id.turku);
        profileImage = findViewById(R.id.profileImage);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);

        txtName = findViewById(R.id.txtDashboard);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/CollegiateFLF.ttf"); //Font tipi ayarlama
        txtName.setTypeface(typeface);

        init();

        profileImage.setOnClickListener(new View.OnClickListener() {  //profile sayfasina gidiyor
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anaekran.this,profile.class);
                startActivity(intent);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //rock muzik turunun sayfasina gidiyor
                Intent intent = new Intent(anaekran.this,rockpage.class);
                startActivity(intent);
            }
        });


    }



}
