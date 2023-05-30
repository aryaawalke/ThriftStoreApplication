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

public class ElectronicsActivity extends AppCompatActivity {
    LinearLayout e1, e2;
    private TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        e1 = findViewById(R.id.i_e1);
        e2 = findViewById(R.id.i_e2);


        e1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ElectronicsActivity.this, "camera has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ElectronicsActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(ElectronicsActivity.this, "speaker has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ElectronicsActivity.this, SpeakerActivity.class);
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
                Toast.makeText(ElectronicsActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ElectronicsActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}