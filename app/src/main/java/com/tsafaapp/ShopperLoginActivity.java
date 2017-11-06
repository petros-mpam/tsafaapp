package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShopperLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_login);

        final EditText etshopemaillogin = (EditText) findViewById(R.id.etshopemaillogin);
        final EditText etshoppasswordlogin = (EditText) findViewById(R.id.etshoppasswordlogin);
        final TextView shopsignup = (TextView) findViewById(R.id.shopsignup);   //or sign up
        final CardView cvShopperlogin = (CardView) findViewById(R.id.cvShopperlogin); //proceed to the shop profile after login



        shopsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent shopsignupIntent = new Intent(ShopperLoginActivity.this,ShopperRegisterActivity.class);
                ShopperLoginActivity.this.startActivity(shopsignupIntent);
            }
        });

        cvShopperlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent shoploginIntent = new Intent (ShopperLoginActivity.this,ShopProfileActivity.class);
                ShopperLoginActivity.this.startActivity(shoploginIntent);
            }
        });




    }
}
