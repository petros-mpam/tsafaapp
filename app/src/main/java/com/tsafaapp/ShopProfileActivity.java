package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ShopProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_profile);
        TextView blogout=(TextView) findViewById(R.id.bLogout);
        final CardView cardViewaddnewoffer = (CardView) findViewById(R.id.cardViewaddnewoffer);

        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,ShopperLoginActivity.class));
        }

        //FirebaseUser user=firebaseAuth.getCurrentUser();



       blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(ShopProfileActivity.this,ShopperLoginActivity.class));
            }
        });



        cardViewaddnewoffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent shopAddOfferIntent = new Intent(ShopProfileActivity.this,AddNewProductOfferActivity.class);
                ShopProfileActivity.this.startActivity(shopAddOfferIntent);
            }
        });

    }
}
