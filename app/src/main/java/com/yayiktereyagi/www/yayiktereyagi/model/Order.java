package com.yayiktereyagi.www.yayiktereyagi.model;

/**
 * Created by WİN8.1 on 2/5/2017.
 */

public class Order {
    public String tarih;
    public String miktar;
    public int iconId;


    public Order() {

    }

    public Order(String tarih, String miktar, int iconId) {
        this.tarih = tarih;
        this.miktar = miktar;
        this.iconId = iconId;
    }

    public Order(String tarih, String miktar) {
        this.tarih = tarih;
        this.miktar = miktar;
    }



    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getTarih() {
        return tarih;
    }

    public String getMiktar() {
        return miktar;
    }
}
