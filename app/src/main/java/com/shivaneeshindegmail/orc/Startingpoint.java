package com.shivaneeshindegmail.orc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Startingpoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingpoint);
        final Button centrallink= (Button) findViewById(R.id.button);
        final Button westernlink= (Button) findViewById(R.id.button2);
        final Button harbourink= (Button) findViewById(R.id.button3);

 /*       centrallink.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v) {
                Intent centralIntent = new Intent(Startingpoint.this, Login.class);
                Startingpoint.this.startActivity(centralIntent);
            }
        });

        westernlink.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v) {
                Intent westernIntent = new Intent(Startingpoint.this, Wlogin.class);
                Startingpoint.this.startActivity(westernIntent);
            }
        });

        harbourink.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v) {
                Intent harbourIntent = new Intent(Startingpoint.this, hLogin.class);
                Startingpoint.this.startActivity(harbourIntent);
            }
        });*/

        centrallink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        Login.class);
                startActivity(i);
                finish();
            }
        });

        westernlink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        Wlogin.class);
                startActivity(i);
                finish();
            }
        });

        harbourink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        Hlogin.class);
                startActivity(i);
                finish();
            }
        });
    }
}
