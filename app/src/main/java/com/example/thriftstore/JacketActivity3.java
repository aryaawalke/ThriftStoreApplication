package com.example.thriftstore;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class JacketActivity3 extends AppCompatActivity {
    // Define the product details
    private String productName;
    private String productPrice;
    private int productImage;
    private TextView count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacket3);

        // Initialize the product details
        productName = "Formal Jacket";
        productPrice = "1500";
        productImage = R.drawable.jacket3;


        // Set up the "Add to Cart" button
        Button addToCartButton = findViewById(R.id.add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add the product to the user's cart in Firestore
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                Map<String, Object> cartMap = new HashMap<>();
                cartMap.put("productName", productName);
                cartMap.put("productPrice", productPrice);
                cartMap.put("productImage", productImage);

                db.collection("carts").document(userId).collection("items")
                        .add(cartMap)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(JacketActivity3.this, "Added to cart", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(JacketActivity3.this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
                            }
                        });
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
                Toast.makeText(JacketActivity3.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(JacketActivity3.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}

