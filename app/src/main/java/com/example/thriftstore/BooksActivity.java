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

public class BooksActivity extends AppCompatActivity {
    LinearLayout b1, b2, b3, b4;
    private TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        b1 = findViewById(R.id.i_b1);
        b2 = findViewById(R.id.i_b2);
        b3 = findViewById(R.id.i_b3);
        b4 = findViewById(R.id.i_b4);



        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(BooksActivity.this, "b1 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BooksActivity.this, ThrillerActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(BooksActivity.this, "b2 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BooksActivity.this, HorrorActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(BooksActivity.this, "b3 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BooksActivity.this, NFActivity.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(BooksActivity.this, "b4 has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BooksActivity.this, KidsActivity.class);
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
                Toast.makeText(BooksActivity.this, "skirts has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BooksActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}