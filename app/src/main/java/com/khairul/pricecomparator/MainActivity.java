package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        //recycler view
        List<ProductItem> list = new ArrayList<>();
        list.add(new ProductItem("sun", 8.99,100));
        list.add(new ProductItem("sun2", 81.99,100));


        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
//        productViewModel.getAllProducts().observe(this, posts->{
//
//            productAdapter.setData(posts);
//        });
        //productViewModel.getAllProducts().observe();




        //productAdapter  = new ProductAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RVProductItems.setLayoutManager(layoutManager);
        RVProductItems.setAdapter(productAdapter);


    }

    private void initViews(){
        CLNewRecord = findViewById(R.id.CLNewRecord);
        RVProductItems = findViewById(R.id.RVProductItems);
    }
}