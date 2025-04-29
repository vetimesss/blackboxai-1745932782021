package com.example.stockmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStockInOut, btnNewOrder, btnAddSupplier, btnCreateProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStockInOut = findViewById(R.id.btnStockInOut);
        btnNewOrder = findViewById(R.id.btnNewOrder);
        btnAddSupplier = findViewById(R.id.btnAddSupplier);
        btnCreateProduct = findViewById(R.id.btnCreateProduct);

btnStockInOut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, StockInOutActivity.class);
        startActivity(intent);
    }
});

btnNewOrder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NewOrderActivity.class);
        startActivity(intent);
    }
});

btnAddSupplier.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, AddSupplierActivity.class);
        startActivity(intent);
    }
});

btnCreateProduct.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CreateProductActivity.class);
        startActivity(intent);
    }
});
    }
}
