package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopperLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_login);

       final TextView shopsignup = (TextView) findViewById(R.id.shopsignup);   //or sign up

        shopsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent shopsignupIntent = new Intent(ShopperLoginActivity.this,ShopperRegisterActivity.class);
                ShopperLoginActivity.this.startActivity(shopsignupIntent);
            }
        });


    }
}
