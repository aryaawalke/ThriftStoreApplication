package com.example.thriftstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class PaymentActivity extends AppCompatActivity {


    private Button mPayButton;
    private TextView mTotalAmountTextView;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mPayButton = findViewById(R.id.pay_button);
        mTotalAmountTextView = findViewById(R.id.total_amount_textview);

        // Get the total amount from the previous activity
        Intent intent = getIntent();
        int totalAmount = intent.getIntExtra("totalAmount", 0);

        // Set the total amount text
        mTotalAmountTextView.setText(String.format("Total amount: %d", totalAmount));

        mPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show a dialog to confirm payment
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Confirm Payment");
                builder.setMessage("Are you sure you want to pay for these items?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // update order status to "paid" in the database
                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        db.collection("orders").document(userId).update("status", "paid")
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(PaymentActivity.this, "Payment successful", Toast.LENGTH_SHORT).show();
                                        // clear the cart

                                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                                        db.collection("carts").document(userId).delete()
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        // refresh the page to remove the paid items from the cart
                                                        Intent intent = getIntent();
                                                        finish();
                                                        startActivity(intent);
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(PaymentActivity.this, "Failed to clear cart", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(PaymentActivity.this, "Payment failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
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
                Toast.makeText(PaymentActivity.this, "cart has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PaymentActivity.this, CartActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}