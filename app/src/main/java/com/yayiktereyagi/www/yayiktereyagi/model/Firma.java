package com.yayiktereyagi.www.yayiktereyagi.model;

import java.util.ArrayList;

/**
 * Created by WİN8.1 on 1/18/2017.
 */
public class Firma{
    String firmaAdi;
    String Uid;
    String ePostaAdresi;
    String telefonNumarasi;
    String sifre;
    String firmaAdres;


    public Firma() {
    }

    public Firma(String firmaAdi, String uid, String ePostaAdresi) {
        this.firmaAdi = firmaAdi;
        Uid = uid;
        this.ePostaAdresi = ePostaAdresi;
    }

    public Firma(String firmaAdi, String ePostaAdresi) {
        this.firmaAdi = firmaAdi;
        this.ePostaAdresi = ePostaAdresi;
    }


}
