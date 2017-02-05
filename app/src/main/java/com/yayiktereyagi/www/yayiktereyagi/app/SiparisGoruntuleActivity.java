package com.yayiktereyagi.www.yayiktereyagi.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yayiktereyagi.www.yayiktereyagi.R;
import com.yayiktereyagi.www.yayiktereyagi.model.Order;

import java.util.ArrayList;
import java.util.List;

public class SiparisGoruntuleActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mdb;

    private List<Order> orderList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis_goruntule);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);

        initData();
        //kayitlariGetir();
        mdb = FirebaseDatabase.getInstance();
        OrderAdapter adapter=new OrderAdapter(orderList);
        mRecyclerView.setAdapter(adapter);



}
    //manuel eklme yaptığım method
    private void initData(){
        orderList=new ArrayList<>();
        orderList.add(new Order("01.01.2017", "55kg", R.drawable.ic_siparis_alindi_24dp));
        orderList.add(new Order("11.01.2017", "54kg", R.drawable.ic_siparis_alindi_24dp));
        orderList.add(new Order("21.11.2016", "75kg", R.drawable.ic_siparis_alindi_24dp));
        orderList.add(new Order("04.01.2017", "544kg", R.drawable.ic_siparis_alindi_24dp));


    }
    // Firebaseden veri cekmeye calıştığım method
    public void kayitlariGetir(){

        DatabaseReference dbGelenler=mdb.getReference("Siparisler");
        dbGelenler.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               for (DataSnapshot gelenler:dataSnapshot.getChildren()){

                   Order s=new Order();
                   s.setTarih(gelenler.getValue(Order.class).getTarih());
                    s.setMiktar(gelenler.getValue(Order.class).getMiktar());

                   orderList.add(s);


                 // Order siparis=  gelenler.getValue(Order.class);
                  //orders.add(siparis);

               }
                if(orderList.size()>0)
                {
                    //adapter=new OrderAdapter(SiparisGoruntuleActivity.this, orders);
                    //mRecyclerView.setAdapter(adapter);
                }else {
                    Toast.makeText(SiparisGoruntuleActivity.this,"No data",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
/*
for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Movie m=new Movie();
            m.setName(ds.getValue(Movie.class).getName());
            m.setDescription(ds.getValue(Movie.class).getDescription());

            movies.add(m);
        }

        if(movies.size()>0)
        {
            adapter=new MyAdapter(MainActivity.this,movies);
            rv.setAdapter(adapter);
        }else {
            Toast.makeText(MainActivity.this,"No data",Toast.LENGTH_SHORT).show();
        }
 */

