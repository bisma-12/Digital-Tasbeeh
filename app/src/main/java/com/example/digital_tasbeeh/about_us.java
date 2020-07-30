package com.example.digital_tasbeeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.regex.Pattern;

public class about_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView txt_about=(TextView)findViewById(R.id.text_about);
        txt_about.getText();
        Pattern pattern=Pattern.compile("[A-Z]+");
        Linkify.addLinks(txt_about,pattern,"http://www.google.ie/search?q=");
    }
}