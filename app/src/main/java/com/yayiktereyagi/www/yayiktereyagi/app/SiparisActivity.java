package com.yayiktereyagi.www.yayiktereyagi.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yayiktereyagi.www.yayiktereyagi.R;
import com.yayiktereyagi.www.yayiktereyagi.model.Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SiparisActivity extends AppCompatActivity  {
    EditText mCompanyEditText;
    EditText mNameEditText;
    EditText mNumberEditText;
    Spinner mWhenSpinner;
    Button btnGonder;


     FirebaseDatabase db;
    final static int SIPARIS_ALINDI = 100;
    final static int SIPARIS_ILETILDI = 101;
    final static int SIPARIS_ODENDI = 102;

    final static int ENKISA_ZAMANDA = 0;
    final static int UC_BES_GUN_ICINDE = 1;
    final static int BES_YEDI_GUN_ICINDE = 2;
    int mWhen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis);

        mCompanyEditText= (EditText) findViewById(R.id.firmaAdi);
        mNameEditText= (EditText) findViewById(R.id.sahisAdi);
        mNumberEditText= (EditText) findViewById(R.id.miktar);
        mWhenSpinner= (Spinner) findViewById(R.id.neZamanSpinner);

        db=FirebaseDatabase.getInstance();

        setupSpinner();
        Intent intent = getIntent();
        String companyName = intent.getStringExtra(MainActivity.COMPANYNAME);
        String name = intent.getStringExtra(MainActivity.NAME);
        String number=intent.getStringExtra(MainActivity.NUMBER);
        int when = (int) intent.getLongExtra(MainActivity.WHEN,0);
        mWhen =when;

        if (when ==
                UC_BES_GUN_ICINDE) {
            mWhenSpinner.setSelection(1);

        } else if (when == BES_YEDI_GUN_ICINDE) {
            mWhenSpinner.setSelection(2);

        } else {
            mWhenSpinner.setSelection(0);

        }
        mCompanyEditText.setText(companyName);
        mNameEditText.setText(name);
        mNumberEditText.setText(number);
    }
    public void gonder(View view){
        btnGonder= (Button) findViewById(R.id.gonderButton);
        String companyName=mCompanyEditText.getText().toString();
        String kisiAdi=mNameEditText.getText().toString();
        String miktar=mNumberEditText.getText().toString();
        long neZaman=mWhen;

        Calendar c=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        String tarih=sdf.format(c.getTime());

        int siparisDurum=SIPARIS_ALINDI;//R.drawable.ic_siparis_alindi_24dp;
       // Firma siparis= new Firma(companyName, personName,kilogramName, deadline, tarih, siparisDurum);
        //siparis olustur
        //Siparis yeniSiparis = new Siparis(kisiAdi, tarih, miktar, (int) neZaman, siparisDurum);
        //ekle(siparis);
        //ekle(yeniSiparis);
        Order order=new Order(tarih, miktar);
        ekle(order);
        Toast.makeText(this, "siparişiniz alınmıştır", Toast.LENGTH_SHORT).show();
    }
    public void ekle(Order siparis){

        DatabaseReference dbref=db.getReference("Siparisler");
        String key=dbref.push().getKey();
        DatabaseReference dbRefYeni=db.getReference("Siparisler/"+key);
        dbRefYeni.setValue(siparis);


    }

    private void setupSpinner() {
        ArrayAdapter spinneradapter=ArrayAdapter.createFromResource(this, R.array.when_array, android.R.layout.simple_spinner_dropdown_item);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mWhenSpinner.setAdapter(spinneradapter);
        mWhenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(!TextUtils.isEmpty(selection)){
                   if (selection.equals(getString(R.string.when_besyedi))){
                       mWhen=BES_YEDI_GUN_ICINDE;
                   }
                    else if (selection.equals(getString(R.string.when_ucbes))){
                       mWhen=UC_BES_GUN_ICINDE;
                   }
                    else {
                       mWhen=ENKISA_ZAMANDA;
                   }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mWhen=ENKISA_ZAMANDA;

            }
        });




    }


}
