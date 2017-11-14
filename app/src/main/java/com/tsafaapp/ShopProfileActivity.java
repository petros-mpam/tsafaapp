package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ShopProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_profile);

        final CardView cardViewaddnewoffer = (CardView) findViewById(R.id.cardViewaddnewoffer);

        cardViewaddnewoffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent shopAddOfferIntent = new Intent(ShopProfileActivity.this,AddNewProductOfferActivity.class);
                ShopProfileActivity.this.startActivity(shopAddOfferIntent);
            }
        });

    }
}
