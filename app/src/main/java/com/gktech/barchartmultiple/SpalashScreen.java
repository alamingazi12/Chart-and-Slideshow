package com.gktech.barchartmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpalashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash_screen);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            Intent intent=new Intent(SpalashScreen.this,MainActivity.class);
            startActivity(intent);

        }
    },3000);


    }
}
