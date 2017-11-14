package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class ShopperLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_login);

        final TextView shopsignup = (TextView) findViewById(R.id.shopsignup);
        final CardView cvShopperlogin = (CardView) findViewById(R.id.cvShopperlogin);

        shopsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shopsignupIntent = new Intent(ShopperLoginActivity.this,ShopperRegisterActivity.class);
                ShopperLoginActivity.this.startActivity(shopsignupIntent);
            }
        });

        cvShopperlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2){
                Intent shopProfileIntent = new Intent(ShopperLoginActivity.this,ShopProfileActivity.class);
                ShopperLoginActivity.this.startActivity(shopProfileIntent);
            }
        });
    }
}
