package com.example.thriftstore;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView1, imageView2, imageView3,imageView4, imageView5, imageView6 ;
    RelativeLayout r1, r2, r3, r4;
    private TextView count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        r1 = findViewById(R.id.r_electric);
        r2 = findViewById(R.id.r_clothes);
        r3 = findViewById(R.id.r_shoes);
        r4 = findViewById(R.id.r_books);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ElectronicsActivity.class);
                startActivity(intent);
            }
        });


        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ClothesActivity.class);
                startActivity(intent);
            }
        });


        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ShoesActivity.class);
                startActivity(intent);
            }
        });


        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, BooksActivity.class);
                startActivity(intent);
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
                Toast.makeText(MainActivity2.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity2.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}