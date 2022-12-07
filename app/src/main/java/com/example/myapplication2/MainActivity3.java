package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;






public class MainActivity3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void vibrate(View view) {
        Vibrator vibrator;
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }


        public void tip_1_clicked(View view) {
        startActivity(new Intent(view.getContext(), MainActivity5.class));}

        public void tip_2_clicked(View view) {
        startActivity(new Intent(view.getContext(), MainActivity6.class));}

        public void tip_3_clicked(View view) {
            findViewById(R.id.tip_1).setVisibility(View.INVISIBLE);
            findViewById(R.id.tip_2).setVisibility(View.INVISIBLE);
            findViewById(R.id.read_more_btn3).setVisibility(View.INVISIBLE);
            findViewById(R.id.line3).setVisibility(View.VISIBLE);
        }


        public void go_to_home(View view) {
            vibrate(view);
            startActivity(new Intent(view.getContext(), MainActivity2.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        public void go_to_support(View view) {
            vibrate(view);
            startActivity(new Intent(view.getContext(), MainActivity7.class));
        }
        public void go_to_about_us(View view) {
            vibrate(view);
            startActivity(new Intent(view.getContext(), MainActivity8.class));
        }
        public void go_back(View view) {
            finish();
         }



}