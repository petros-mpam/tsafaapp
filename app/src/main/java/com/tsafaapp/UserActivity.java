package com.tsafaapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.games.snapshot.Snapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
Button clickme;
public static TextView textclickme;
    private FirebaseAuth firebaseAuth;

    final FirebaseDatabase Usersdatabase=FirebaseDatabase.getInstance();
    final FirebaseDatabase ShopDatabase=FirebaseDatabase.getInstance();
    DatabaseReference Users=Usersdatabase.getReference("Users");
    DatabaseReference Shop=ShopDatabase.getReference("Shop");

     String idpro1;
    Query query = Shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
       final TextView tvemail=(TextView)findViewById(R.id.tvemail);
     final   Button bcshop=(Button)findViewById(R.id.bcshop);
        Button blogout=(Button)findViewById(R.id.bLogout1);
        firebaseAuth =firebaseAuth.getInstance();
        clickme = (Button) findViewById(R.id.clickme);
        textclickme = (TextView)findViewById(R.id.textclickme);


        clickme.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

fetchData process = new fetchData();
process.execute();
            }
        });

////////////////////////////////////////////////////////////////////////////////
/// // DN KSERW PWS TO EKANA ALLA MIN TO AGGIKSETE THA FIGETE XWRIS KEFALI/////
/// ////////// AUTO TON KODIKA 8A TON KANETE COPY PASTE SE KATHE KLASI GIA NA MPORITE NA PARETE TO ID APO KATHE MAGAZI KAI TON USER POU TREXEI EKINI TIN WRA//////
/// //// I IF DN XRIAZETAI STIS ALLES KARTELES MONO EDW GIA ELENXO ////

        firebaseAuth=FirebaseAuth.getInstance();
   final     FirebaseUser user=firebaseAuth.getCurrentUser();
       String user1=user.getUid();

        Users.child(user1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PelatisData pelatisData = dataSnapshot.getValue(PelatisData.class);
                  idpro1 = pelatisData.getIdpro();
                if (idpro1.equals("")){
                    bcshop.setText("Create Shop");
                    bcshop.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      startActivity(new Intent(getApplicationContext(), ShopperRegisterActivity.class));
                                                      finish();
                                                  }
                                              });}
                                              else {
                    Shop.child(idpro1).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            PolitisData politisData = dataSnapshot.getValue(PolitisData.class);
                            String name1 = politisData.getName();
                            tvemail.setText("Welcome " + name1);
                            bcshop.setText("My Shop");
                            bcshop.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getApplicationContext(), ShopProfileActivity.class));
                                }
                            });

                            query = Shop.child(idpro1);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

/////////////////////////////////////////////////////////////////////////////////////////////////////////

      // tvemail.setText("Welcome "+idpro1);
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        bcshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ShopperRegisterActivity.class));
                finish();
            }
        });



        //Read Data from the Database about recycleview menu (peter)
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recyler_data");
        ////////////////////////////////////////////////////////////////////






      //  tvemail.setText("Welcome "+user.getUid());

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(UserActivity.this,LoginActivity.class));
            }
        });










    }
}
