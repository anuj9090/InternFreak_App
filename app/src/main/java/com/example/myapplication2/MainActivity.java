package com.example.myapplication2;

import static com.android.volley.toolbox.Volley.newRequestQueue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.List;


import java.net.UnknownHostException;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    String url = "https://anujg.co/";
    String img_url;
    String company_name;
    String batch;
    String designation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView =findViewById(R.id.company_image);

        img_url = "https://internfreak.co/uploads/" + getIntent().getExtras().getString("company_name");
        company_name = getIntent().getExtras().getString("company_name").replaceAll(".png", "");
        batch = getIntent().getExtras().getString("Qualification");
        designation = getIntent().getExtras().getString("designation");



        Glide.with(this)
                .load(img_url).centerCrop()
                .into(imageView);


        TextView company = (TextView)findViewById(R.id.company_name);
        TextView batch_view = (TextView)findViewById(R.id.batch_op);
        TextView location = (TextView)findViewById(R.id.location_op);
        TextView designation_view = (TextView)findViewById(R.id.designation);
        TextView ctc = (TextView)findViewById(R.id.ctc);

        TextView khaliDabbaHeading = (TextView)findViewById(R.id.khaliDabbaHeading);
        TextView khaliDabbaDescription = (TextView)findViewById(R.id.khaliDabbaDescription);

        TextView requirements_heading = (TextView)findViewById(R.id.requirements_heading);
        TextView requirements_1 = (TextView)findViewById(R.id.requirements_1);
        TextView requirements_2 = (TextView)findViewById(R.id.requirements_2);
        TextView requirements_3 = (TextView)findViewById(R.id.requirements_3);
        TextView requirements_4 = (TextView)findViewById(R.id.requirements_4);
        TextView requirements_5 = (TextView)findViewById(R.id.requirements_5);

        designation_view.append(designation);
        company.setText(company_name);
        batch_view.setText(batch);
        location.setText(getIntent().getExtras().getString("Location"));
        ctc.setText("○ "+getIntent().getExtras().getString("CtcOrStipend")+" : "+getIntent().getExtras().getString("Ctc"));

                    if (getIntent().getExtras().getString("KhaliDabbaHeading").equals("n")) {
                        ViewGroup parent = (ViewGroup) khaliDabbaHeading.getParent();
                        parent.removeView(khaliDabbaHeading);
                    }else{
                        khaliDabbaHeading.setText("○ "+getIntent().getExtras().getString("KhaliDabbaHeading")+" : ");
                    }

                    if (getIntent().getExtras().getString("KhaliDabbaDescription").equals("n")) {
                        ViewGroup parent = (ViewGroup) khaliDabbaDescription.getParent();
                        parent.removeView(khaliDabbaDescription);
                    }else{
                        khaliDabbaDescription.setText("•  "+getIntent().getExtras().getString("KhaliDabbaDescription"));
                    }
                    requirements_heading.setText("○ "+getIntent().getExtras().getString("CandidateShouldHave")+" : ");
                    requirements_1.setText("•  "+getIntent().getExtras().getString("CandidateShouldDescription1"));

                    if (getIntent().getExtras().getString("CandidateShouldDescription2").equals("n")) {
                        ViewGroup parent = (ViewGroup) requirements_2.getParent();
                        parent.removeView(requirements_2);
                    }else{
                        requirements_2.setText("•  "+getIntent().getExtras().getString("CandidateShouldDescription2"));
                    }

                    if (getIntent().getExtras().getString("CandidateShouldDescription3").equals("n")) {
                        ViewGroup parent = (ViewGroup) requirements_3.getParent();
                        parent.removeView(requirements_3);
                    }else{
                        requirements_3.setText("•  "+getIntent().getExtras().getString("CandidateShouldDescription3"));

                    }

                    if (getIntent().getExtras().getString("CandidateShouldDescription4").equals("n")) {
                        ViewGroup parent = (ViewGroup) requirements_4.getParent();
                        parent.removeView(requirements_4);
                    }else{
                        requirements_4.setText("•  "+getIntent().getExtras().getString("CandidateShouldDescription4"));

                    }
                    if (getIntent().getExtras().getString("CandidateShouldDescription5").equals("n")) {
                        ViewGroup parent = (ViewGroup) requirements_5.getParent();
                        parent.removeView(requirements_5);
                    }else{
                        requirements_5.setText("•  "+getIntent().getExtras().getString("CandidateShouldDescription5"));
                    }

                     String applyLink = getIntent().getExtras().getString("ApplyLink");
                                Button btn2 = (Button) findViewById(R.id.applynow);
                                btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(applyLink));
                                        startActivity(i);
                                    }
                                });}

    public void vibrate(View v) {
        Vibrator vibrator;
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

    public void go_to_home(View view) {
        finish();
    }

    public void share_btn(View v) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey, Checkout This Really Amazing Opportunity At " + company_name+"\nRole: "+designation+"\nBatch: "+batch+"\n\nTo Know More, Visit internfreak.co";
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }
}


