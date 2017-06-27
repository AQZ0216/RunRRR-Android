package com.example.android.run;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.run.R;

public class MissionPopActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions_pop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundleReciever = getIntent().getExtras();
        String mName = bundleReciever.getString("name");
        String mTime = bundleReciever.getString("time");
        String mContent = bundleReciever.getString("content");
        String mType = bundleReciever.getString("type");
        String mState = bundleReciever.getString("state");


        //missions type : MAIN,SUB,URG, set different icon
        ImageView Type = (ImageView) findViewById(R.id.list_type);
        switch (mType){
            case "0":
                Type.setImageResource(R.drawable.missions_urg);
                break;
            case "1":
                Type.setImageResource(R.drawable.missions_main_2);
                break;
            case "2":
                Type.setImageResource(R.drawable.missions_sub);
                break;
            default:
                break;
        }

        //state type : -1:unsolved 0:being judged 1:success 2:fail
        switch(mState){
            case "-1":
                break;
            case "0": //waiting
                break;
            case "1": //passed
                break;
            case "2": //failed
                break;
            default:
                break;
        }

        // Set title with mission name
        TextView Name = (TextView) findViewById(R.id.list_name);
        Name.setText(mName);

        // Set content of mission details
        TextView Content = (TextView) findViewById(R.id.mission_content);
        Content.setText(mContent);

        // Set picture of mission details
        ImageView Picture = (ImageView) findViewById(R.id.mission_picture);
        Picture.setImageResource(R.drawable.yichun8787);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}