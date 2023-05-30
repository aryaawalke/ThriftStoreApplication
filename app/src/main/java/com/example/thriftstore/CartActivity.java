package com.example.thriftstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    GridView coursesGV;
    TextView mTotalAmountTextView;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        coursesGV = findViewById(R.id.idGVcourses);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("carts").document(userId).collection("items")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        ArrayList<CourseModel> courseModelArrayList = new ArrayList<>();
                        int totalAmount = 0;
                        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                            String productName = document.getString("productName");
                            String productPrice = document.getString("productPrice");
                            int productImage = document.getLong("productImage").intValue();
                            String documentId = document.getId();
                            courseModelArrayList.add(new CourseModel(productName, productPrice, productImage, documentId));
                            totalAmount += Integer.parseInt(productPrice);
                        }

                        CourseGVAdapter adapter = new CourseGVAdapter(CartActivity.this, courseModelArrayList);
                        coursesGV.setAdapter(adapter);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CartActivity.this, "Failed to load cart items", Toast.LENGTH_SHORT).show();
                    }
                });

        findViewById(R.id.btnCheckout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass the total amount to the PaymentActivity
                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                int totalAmount = Integer.parseInt(mTotalAmountTextView.getText().toString().split(": ")[1]);
                intent.putExtra("totalAmount", totalAmount);
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
                Toast.makeText(CartActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CartActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
