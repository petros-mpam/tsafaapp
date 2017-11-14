package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShopperRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_register);

        final EditText Shopetname = (EditText) findViewById(R.id.Shopetname);
        final EditText Shopetaddress = (EditText) findViewById(R.id.Shopetaddress);
        final EditText Shopetusername = (EditText) findViewById(R.id.Shopetusername);
        final EditText Shopetpassword = (EditText) findViewById(R.id.Shopetpassword);

        //final EditText Shopetrenterpassword = (EditText) findViewById(R.id.Shopetrenterpassword);
        final EditText Shopetemail = (EditText) findViewById(R.id.Shopetemail);
        final EditText ShopetLongitude = (EditText) findViewById(R.id.ShopetLongitude);
        final EditText ShopetLattitude = (EditText) findViewById(R.id.ShopetLattitude);
    }
}
