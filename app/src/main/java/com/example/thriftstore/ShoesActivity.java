package com.example.thriftstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShoesActivity extends AppCompatActivity {
    LinearLayout s1, s2;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);


        s1 = findViewById(R.id.i_s1);
        s2 = findViewById(R.id.i_s2);




        s1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ShoesActivity.this, "b1 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ShoesActivity.this, CasualActivity.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ShoesActivity.this, "s2 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ShoesActivity.this, FestiveActivity.class);
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
                Toast.makeText(ShoesActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ShoesActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}