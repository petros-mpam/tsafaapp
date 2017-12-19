package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ShopProfileActivity extends AppCompatActivity {

    final FirebaseDatabase Usersdatabase=FirebaseDatabase.getInstance();
    final FirebaseDatabase ShopDatabase=FirebaseDatabase.getInstance();
    DatabaseReference Users=Usersdatabase.getReference("Users");
    DatabaseReference Shop=ShopDatabase.getReference("Shop");
    String idpro1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_profile);
        TextView blogout=(TextView) findViewById(R.id.bLogout);
     final   TextView tvname=(TextView)findViewById(R.id.tvname);
        final TextView tvshopsname=(TextView)findViewById(R.id.tvshopsname);
        final TextView tvaddress=(TextView)findViewById(R.id.tvaddress);

        final CardView cardViewaddnewoffer = (CardView) findViewById(R.id.cardViewaddnewoffer);

        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        firebaseAuth=FirebaseAuth.getInstance();
        final FirebaseUser user=firebaseAuth.getCurrentUser();
        String user1=user.getUid();

        Users.child(user1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final PelatisData pelatisData = dataSnapshot.getValue(PelatisData.class);
                idpro1 = pelatisData.getIdpro();
               String username=pelatisData.getUsername();
                tvname.setText("Name: "+username);
                    Shop.child(idpro1).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            PolitisData politisData = dataSnapshot.getValue(PolitisData.class);
                            String name1 = politisData.getName();
                            String address=politisData.getAddress();
                            tvshopsname.setText("Shop's Name: "+name1);
                            tvaddress.setText("Address: "+address);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });}

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }

        );


       blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(ShopProfileActivity.this,LoginActivity.class));
            }
        });



        cardViewaddnewoffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             finish();
             startActivity(new Intent(ShopProfileActivity.this,AddNewProductOfferActivity.class));

            }
        });

    }
}
