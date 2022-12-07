package com.example.myapplication2;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication2.ui.Job;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    String url = "https://anujg.co/";
    public String company_name;
    public String qualification;
    public String category;
    public String location;
    public String designation;
    public String ctcOrStipend;
    public String ctc;
    public String candidateShouldHave;
    public String candidateShouldDescription1;
    public String candidateShouldDescription2;
    public String candidateShouldDescription3;
    public String candidateShouldDescription4;
    public String candidateShouldDescription5;
    public String khaliDabbaHeading;
    public String khaliDabbaDescription;
    public String applyLink;
    public ArrayList<Job> kuchbhi = new ArrayList();
    public RecyclerView posts;
    public RelativeLayout noInternetLayout;
    public Button try_again_button;
    public View navigation_bar;
    public View line;
    public View progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);


        posts =findViewById(R.id.recyclerView);
        noInternetLayout  =findViewById(R.id.noInternetLayout);
        try_again_button  =findViewById(R.id.try_again_button);
        navigation_bar  =findViewById(R.id.navigation_bar);
        line  =findViewById(R.id.line);
        progressbar=findViewById(R.id.progressbar);
        posts.setLayoutManager(new LinearLayoutManager(this));

        drawLayout();

        try_again_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate(v);
                drawLayout();
            }
        });

    }


    private void drawLayout() {

        if(isOnline()){

            posts.setVisibility(View.VISIBLE);
            navigation_bar.setVisibility(View.VISIBLE);
            noInternetLayout.setVisibility(View.INVISIBLE);

            RequestQueue requestQueue;


            requestQueue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        for (int i= 0;i<10;i++){

                            String Json_Data = response.getString(i);
                            JSONObject jObject = new JSONObject(Json_Data);

                            company_name = jObject.getString("image");
                            category = jObject.getString("category");
                            qualification = jObject.getString("qualification");
                            location = jObject.getString("location");
                            designation = jObject.getString("designation");
                            ctcOrStipend = jObject.getString("ctcOrStipend");
                            ctc = jObject.getString("ctc");
                            candidateShouldHave = jObject.getString("candidateShouldHave");
                            candidateShouldDescription1 = jObject.getString("candidateShouldDescription1");
                            candidateShouldDescription2 = jObject.getString("candidateShouldDescription2");
                            candidateShouldDescription3 = jObject.getString("candidateShouldDescription3");
                            candidateShouldDescription4 = jObject.getString("candidateShouldDescription4");
                            candidateShouldDescription5 = jObject.getString("candidateShouldDescription5");
                            khaliDabbaHeading = jObject.getString("khaliDabbaHeading");
                            khaliDabbaDescription = jObject.getString("khaliDabbaDescription");
                            applyLink = jObject.getString("applyLink");

                            kuchbhi.add(new Job(company_name,  qualification,  location,  designation,  ctcOrStipend,  ctc,  candidateShouldHave,  candidateShouldDescription1,  candidateShouldDescription2,  candidateShouldDescription3,  candidateShouldDescription4,  candidateShouldDescription5,  khaliDabbaHeading,  khaliDabbaDescription, applyLink, category));
                        }

                        posts.setAdapter(new postsadapter(kuchbhi));

                    } catch (JSONException e) {

                        Log.e("MYAPP", "unexpected JSON exception", e);
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("TAG", "onErrorResponse: " + error.getMessage());

                    Log.d("myapp", "something went wrong: ");
                }
            });


            requestQueue.add(jsonArrayRequest);
        }else {

            posts.setVisibility(View.INVISIBLE);
            navigation_bar.setVisibility(View.INVISIBLE);
            line.setVisibility(View.INVISIBLE);

            progressbar.setVisibility(View.INVISIBLE);
            noInternetLayout.setVisibility(View.VISIBLE);

        }
    }




    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }



    public void vibrate(View view) {
        Vibrator vibrator;
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

    public void go_to_resources(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity3.class));
    }
    public void go_to_support(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity7.class));
    }
    public void go_to_about_us(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity8.class));
    }
}

