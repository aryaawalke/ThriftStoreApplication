package com.example.thriftstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpeakerActivity extends AppCompatActivity {
    GridView coursesGV;
    private TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("Speaker Description","Rs. 100",R.drawable.speaker1,""));
        courseModelArrayList.add(new CourseModel("Speaker Description","Rs. 200", R.drawable.speaker2,""));
        courseModelArrayList.add(new CourseModel("Speaker Description","Rs. 500", R.drawable.speaker3,""));
        courseModelArrayList.add(new CourseModel("Speaker Description", "Rs. 160",R.drawable.speaker4,""));
        courseModelArrayList.add(new CourseModel("Speaker Description","Rs. 400", R.drawable.speaker5,""));
        courseModelArrayList.add(new CourseModel("Speaker Description","Rs. 700", R.drawable.speaker,""));


        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                count = (TextView)findViewById(R.id.textView);
                Toast.makeText(SpeakerActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SpeakerActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}