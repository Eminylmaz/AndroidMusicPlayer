package com.example.muhammed.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class rockpage extends AppCompatActivity {

    TextView sammy,kansas,scarpion,molly,styx,special,ramjam,john,yes,war;

    public void init(){

        sammy =(TextView) findViewById(R.id.sammy);
        kansas =(TextView) findViewById(R.id.kansas);
        scarpion =(TextView) findViewById(R.id.scarpion);
        molly =(TextView) findViewById(R.id.molly);
        styx =(TextView) findViewById(R.id.styx);
        special =(TextView) findViewById(R.id.special);
        ramjam =(TextView) findViewById(R.id.ramjam);
        john =(TextView) findViewById(R.id.john);
        yes =(TextView) findViewById(R.id.yes);
        war =(TextView) findViewById(R.id.war);

    }

    public void tiklama(){

        sammy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rockpage.this,muzikekrani.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockpage);
        init();
        tiklama();

    }
}
