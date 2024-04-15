package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import RoomDB.ProductItem;
import RoomDB.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout CLNewRecord;
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
                Intent intent  = new Intent(MainActivity.this, ProductItemDetails.class);
                startActivity(intent);
            }
        });

        // dummy data recycler view
        List<ProductItem> list = new ArrayList<>();
//        list.add(new ProductItem("sun", 8.99,100));
//        list.add(new ProductItem("sun2", 81.99,100));

        //setup recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        RVProductItems.setLayoutManager(layoutManager);

        //get data from room db
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        //populate in recycler view
        productViewModel.getAllProducts().observe(this, new Observer<List<ProductItem>>() {
            @Override
            public void onChanged(List<ProductItem> productItems) {

                productAdapter = new ProductAdapter(productItems);
                RVProductItems.setAdapter(productAdapter);
            }
        });






    }

    private void initViews(){
        CLNewRecord = findViewById(R.id.CLNewRecord);
        RVProductItems = findViewById(R.id.RVProductItems);
    }
}