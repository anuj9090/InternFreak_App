package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity implements
        View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button img1_btn = (Button) findViewById(R.id.img1_btn);
        img1_btn.setOnClickListener(this);
        Button img1_btn2 = (Button) findViewById(R.id.img1_btn2);
        img1_btn2.setOnClickListener(this);

        Button img2_btn = (Button) findViewById(R.id.img2_btn);
        img2_btn.setOnClickListener(this);
        Button img2_btn2 = (Button) findViewById(R.id.img2_btn2);
        img2_btn2.setOnClickListener(this);

        Button img3_btn = (Button) findViewById(R.id.img3_btn);
        img3_btn.setOnClickListener(this);
        Button img3_btn2 = (Button) findViewById(R.id.img3_btn2);
        img3_btn2.setOnClickListener(this);

        Button img4_btn = (Button) findViewById(R.id.img4_btn);
        img4_btn.setOnClickListener(this);
        Button img4_btn2 = (Button) findViewById(R.id.img4_btn2);
        img4_btn2.setOnClickListener(this);

        Button img5_btn = (Button) findViewById(R.id.img5_btn);
        img5_btn.setOnClickListener(this);
        Button img5_btn2 = (Button) findViewById(R.id.img5_btn2);
        img5_btn2.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.img1_btn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3pjrW42")));
                break;

            case R.id.img1_btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3pfVGPp")));
                break;

            case R.id.img2_btn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3Ahr3zb")));
                break;

            case R.id.img2_btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3C7DUFG")));
                break;

            case R.id.img3_btn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3h0ojM4")));
                break;

            case R.id.img3_btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3Afyo1d")));
                break;

            case R.id.img4_btn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3K0Rj4g")));
                break;

            case R.id.img4_btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3dvyIko")));
                break;

            case R.id.img5_btn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3AlRrb3")));
                break;

            case R.id.img5_btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3Prc0am")));
                break;



            default:
                break;
        }

    }
}