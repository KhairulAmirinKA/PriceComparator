package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import RoomDB.ProductItem;
import RoomDB.ProductViewModel;

public class ProductItemDetails extends AppCompatActivity {

    ImageView IVBack;
    EditText ETProductName, ETProductPrice, ETProductQuantity;
    Button BtnAddDetails;

    ProductViewModel productViewModel;

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
                double pricePerQuantity=0;

                if (!TextUtils.isEmpty(productName) &&
                        !TextUtils.isEmpty(ETProductPrice.getText().toString())
                        && !TextUtils.isEmpty(ETProductQuantity.getText().toString())) {

                    productPrice = Double.parseDouble(ETProductPrice.getText().toString());
                    productQuantity = Double.parseDouble(ETProductQuantity.getText().toString());

                    //calc price per quantity
                    pricePerQuantity = productPrice / productQuantity;

                    ProductItem currentProduct = new ProductItem(productName, productPrice, productQuantity, pricePerQuantity);

                    //view model
                    productViewModel = new ViewModelProvider(ProductItemDetails.this).get(ProductViewModel.class);

                    productViewModel.insertProduct(currentProduct);


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