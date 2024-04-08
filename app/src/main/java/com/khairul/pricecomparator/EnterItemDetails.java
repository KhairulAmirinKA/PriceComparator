package com.khairul.pricecomparator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EnterItemDetails extends AppCompatActivity {

    ImageView IVBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_item_details);

        IVBack = findViewById(R.id.IVBack);
        IVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(EnterItemDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}