package com.example.thriftstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JacketsActivity extends AppCompatActivity {
    GridView coursesGV;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackets);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("Jean Jacket","Rs. 1300",R.drawable.jacket1,""));
        courseModelArrayList.add(new CourseModel("Formal Jacket","Rs. 1100", R.drawable.jacket2,""));
        courseModelArrayList.add(new CourseModel("Winter Jacket","Rs. 500", R.drawable.jacket3,""));
        courseModelArrayList.add(new CourseModel("White Jacket", "Rs. 400",R.drawable.jacket4,""));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);

        coursesGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseModel courseModel = (CourseModel) parent.getItemAtPosition(position);


                if (position == 0) {
                    Intent intent = new Intent(JacketsActivity.this, JacketActivity1.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(JacketsActivity.this, JacketActivity2.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(JacketsActivity.this, JacketActivity3.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(JacketsActivity.this, JacketActivity4.class);
                    startActivity(intent);
                }
            }
        });
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
                Toast.makeText(JacketsActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(JacketsActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}