package com.example.dealeaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class buy_details extends AppCompatActivity {

    TextView dProduct, dDesc, dPrice, dContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_details);

        dProduct = (TextView)findViewById(R.id.dProduct);
        dDesc = (TextView)findViewById(R.id.dDesc);
        dPrice = (TextView)findViewById(R.id.dPrice);
        dContact = (TextView)findViewById(R.id.dContact);

        Intent intent = getIntent();
        dProduct.setText(intent.getStringExtra("dProduct"));
        dDesc.setText(intent.getStringExtra("dDesc"));
        dPrice.setText(intent.getStringExtra("dPrice"));
        dContact.setText(intent.getStringExtra("dContact"));
    }
}