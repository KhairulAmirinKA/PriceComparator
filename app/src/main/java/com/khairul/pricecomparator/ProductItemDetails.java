package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProductItemDetails extends AppCompatActivity {

    ImageView IVBack;
    EditText ETProductName, ETProductPrice, ETProductQuantity;

    Button BtnAddDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item_details);

        //find view by id
        initViews();

        IVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(ProductItemDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        IVBack = findViewById(R.id.IVBack);

        ETProductName = findViewById(R.id.ETProductName);
        ETProductPrice = findViewById(R.id.ETProductPrice);
        ETProductQuantity = findViewById(R.id.ETProductQuantity);

        BtnAddDetails = findViewById(R.id.BtnAddDetails);
    }
}