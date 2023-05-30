package com.example.thriftstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClothesActivity extends AppCompatActivity {
LinearLayout clothes, clothes1, clothes2, clothes3;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        clothes = findViewById(R.id.i_clothes);
        clothes1 = findViewById(R.id.i_clothes1);
        clothes2 = findViewById(R.id.i_clothes2);
        clothes3 = findViewById(R.id.i_clothes3);

        clothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ClothesActivity.this, "skirts has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ClothesActivity.this, SkirtsActivity.class);
                startActivity(intent);
            }
        });

        clothes1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ClothesActivity.this, "jackets has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ClothesActivity.this, JacketsActivity.class);
                startActivity(intent);
            }
        });

        clothes2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ClothesActivity.this, "tops has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ClothesActivity.this, TopActivity.class);
                startActivity(intent);
            }
        });

        clothes3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ClothesActivity.this, "jeans has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ClothesActivity.this, TopActivity.class);
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
                Toast.makeText(ClothesActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ClothesActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }


        }