package com.khairul.pricecomparator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import RoomDB.ProductItem;
import RoomDB.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout CLNewRecord, CLSortRecords, CLClearRecords;
    private RecyclerView RVProductItems;

    private ProductAdapter productAdapter;

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by id
        initViews();

        //click make new record
        CLNewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductItemDetails.class);
                startActivity(intent);
            }
        });


        //setup recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        RVProductItems.setLayoutManager(layoutManager);

        //get data from room db. use ViewModel
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        //populate in recycler view.
        productViewModel.getAllProducts().observe(this, new Observer<List<ProductItem>>() {
            @Override
            public void onChanged(List<ProductItem> productItems) {

                productAdapter = new ProductAdapter(productItems);
                RVProductItems.setAdapter(productAdapter);
            }
        });

        //click SORT button
        CLSortRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display sorted products
                productViewModel.sortProducts().observe(MainActivity.this, new Observer<List<ProductItem>>() {
                    @Override
                    public void onChanged(List<ProductItem> sortedProductItems) {

                        productAdapter.updateData(sortedProductItems);
                    }
                });
                Toast.makeText(MainActivity.this, "Products sorted", Toast.LENGTH_SHORT).show();

            }
        });

        //click clear button
        CLClearRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Clear All Products");
                builder.setMessage("Do you want to clear all the products?")

                        //Yes button
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //delete from database
                                productViewModel.deleteAll();

                                Toast.makeText(MainActivity.this, "All products cleared", Toast.LENGTH_SHORT).show();
                            }
                        })

                        //No button
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog dialog = builder.create();

                //customize color
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {

                        //Yes button
                        Button button = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_POSITIVE);

                        //set the button color to red
                        if (button != null) {
                            button.setTextColor(Color.RED);
                        }
                    }
                });

                dialog.show();

            }
        });


    }

    private void initViews() {
        CLNewRecord = findViewById(R.id.CLNewRecord);
        CLSortRecords = findViewById(R.id.CLSortRecords);
        CLClearRecords = findViewById(R.id.CLClearRecords);

        RVProductItems = findViewById(R.id.RVProductItems);
    }
}