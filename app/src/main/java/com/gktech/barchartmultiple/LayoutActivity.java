package com.gktech.barchartmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class LayoutActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        textView=findViewById(R.id.font_test);

        Typeface tf=Typeface.createFromAsset(getAssets(), "font/RobotoCondensed-Regular.ttf");
        textView.setTypeface(tf);

    }
}
