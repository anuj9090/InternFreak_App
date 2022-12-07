package com.example.myapplication2;

import static android.app.PendingIntent.getActivity;

import static org.stringtemplate.v4.misc.Misc.getFileName;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity7 extends AppCompatActivity {

    Button btn;
    Button textop;
    String resume_name;
    String resume_src;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        textop = findViewById(R.id.textop);
        btn = findViewById(R.id.btn);

        SharedPreferences get_pref = getSharedPreferences("resume",MODE_PRIVATE);
        String resume = get_pref.getString("resume_name","Your Resume");
        boolean resume_added = get_pref.getBoolean("resume_added",false);
        if(resume_added){
            btn.setVisibility(View.INVISIBLE);
            textop.setText(resume);
            textop.setVisibility(View.VISIBLE);

        }

    }

    ActivityResultLauncher<Intent> sActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        btn.setVisibility(View.GONE);

                        Intent data = result.getData();
                        Uri uri = data.getData();
                        resume_src = uri.getPath();


                        // getting the name of the file

                        String[] projection = { MediaStore.Files.FileColumns.DATA };
                        Cursor returnCursor = getContentResolver().query(uri, projection, null, null, null);
                        int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                        int column_index = returnCursor.getColumnIndexOrThrow(projection[0]);
                        returnCursor.moveToFirst();

                        // getting the path of the file

//                        projection = {MediaStore.Files.FileColumns.DATA};
//                        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
//                        int column_index = cursor.getColumnIndexOrThrow(projection[0]);
//                        cursor.moveToFirst();

                        resume_src = returnCursor.getString(column_index);

                        textop.setText(resume_src);
                        btn.setVisibility(View.INVISIBLE);
                        textop.setVisibility(View.VISIBLE);
                        shared_pref();
                    }
                }
            }
    );




    public void open_resume(View view) {
        File file = new File(resume_src);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+file));
        startActivity(intent);
    }

    public void shared_pref(){


        SharedPreferences sharedPreferences = getSharedPreferences("resume",MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("resume_name",resume_name);
        editor.putBoolean("resume_added",true);
        editor.apply();
    }

    public void openFileDialog(View view) {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        sActivityResultLauncher.launch(intent);
    }


    public void go_back(View view) {
        finish();
    }

    public void vibrate(View view) {
        Vibrator vibrator;
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

    public void go_to_home(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity2.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void go_to_resources(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity3.class));
    }

    public void go_to_about_us(View view) {
        vibrate(view);
        startActivity(new Intent(view.getContext(), MainActivity8.class));
    }






}