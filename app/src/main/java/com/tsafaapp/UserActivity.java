package com.tsafaapp;


/**
 * Created by WHAAAZAAAP on 14/10/2017.
 */

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    String[] c_names = { "women","men","bags","watches","jewls","sunglasses","accessories","kids"};

   int [] a_items = {R.drawable.women1,R.drawable.men1,R.drawable.bags1,R.drawable.watches1,R.drawable.jewls1, R.drawable.sunglasses1 ,R.drawable.accessories1,R.drawable.kids1};

    Toolbar toolbar;

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<Items> arrayList = new ArrayList<>();

    Button clickme;

public static TextView textclickme;
    private FirebaseAuth firebaseAuth;

    final FirebaseDatabase Usersdatabase=FirebaseDatabase.getInstance();
    final FirebaseDatabase ShopDatabase=FirebaseDatabase.getInstance();
    DatabaseReference Users=Usersdatabase.getReference("Users");
    DatabaseReference Shop=ShopDatabase.getReference("Shop");

     String idpro1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //card view code
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;
        for (String Name : c_names)
        {
            arrayList.add(new Items(Name,a_items[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
//
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
/// ///8A PARNETE OPWSDIPOTE TO SHOP.CHILD(IDPRO1) MPLA MPLA MPLA GIA NA MPORITE NA PERNETE TA VALUES APO TA SHOP KAI 8A BGALE TA KOUMPIA////

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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
