package com.tsafaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddNewProductOffer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product_offer);

        final EditText etCategory = (EditText) findViewById(R.id.etCategory);
        final EditText etProduct = (EditText) findViewById(R.id.etProduct);
        final EditText etInitialValue = (EditText) findViewById(R.id.etInitialValue);
        final EditText etOfferValue = (EditText) findViewById(R.id.etOfferValue);

    }
}
