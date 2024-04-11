package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

        //clicks back btn
        IVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductItemDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //click ADD btn
        BtnAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get text
                String productName = ETProductName.getText().toString();
                double productPrice;
                double productQuantity;

                if (!TextUtils.isEmpty(productName) &&
                        !TextUtils.isEmpty(ETProductPrice.getText().toString())
                        && !TextUtils.isEmpty(ETProductQuantity.getText().toString())) {

                    productPrice = Double.parseDouble(ETProductPrice.getText().toString());
                    productQuantity = Double.parseDouble(ETProductQuantity.getText().toString());


                    Toast.makeText(ProductItemDetails.this, "details saved", Toast.LENGTH_SHORT).show();

                    //go to main activity
                    Intent intent = new Intent(ProductItemDetails.this, MainActivity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(ProductItemDetails.this, "Empty details", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void initViews() {
        IVBack = findViewById(R.id.IVBack);

        ETProductName = findViewById(R.id.ETProductName);
        ETProductPrice = findViewById(R.id.ETProductPrice);
        ETProductQuantity = findViewById(R.id.ETProductQuantity);

        BtnAddDetails = findViewById(R.id.BtnAddDetails);
    }
}