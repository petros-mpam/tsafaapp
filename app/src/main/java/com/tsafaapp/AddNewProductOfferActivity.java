package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddNewProductOfferActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Products=database.getReference("Products");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        firebaseAuth =firebaseAuth.getInstance();


        CardView cardView=(CardView)findViewById(R.id.cardView);
        final EditText etCategory=(EditText)findViewById(R.id.etCategory);
        final EditText etProduct=(EditText)findViewById(R.id.etProduct);
        final EditText etInitialValue=(EditText)findViewById(R.id.etInitialValue);
        final EditText etdescription=(EditText)findViewById(R.id.etdescription);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category=etCategory.getText().toString().trim();
                String pname=etProduct.getText().toString().trim();
                String value=etInitialValue.getText().toString().trim();
                String description=etdescription.getText().toString().trim();
                final  String id=Products.push().getKey();
//                Map<String, Products> products = new HashMap<>();


            }
        });
    }
}
