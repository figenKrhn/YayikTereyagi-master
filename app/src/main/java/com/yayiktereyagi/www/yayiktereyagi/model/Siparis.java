package com.yayiktereyagi.www.yayiktereyagi.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WİN8.1 on 1/18/2017.
 */

public class Siparis {
    String kisiAdi;
    String tarih;
    String miktar;
    int siparisDurum;
    long neZaman;

    public Siparis() {

    }
    @Exclude
    public HashMap<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("Tarih", tarih);
        result.put("Miktar", miktar);


        return result;
    }


    public Siparis(String tarih, String miktar, int siparisDurum) {
        this.tarih = tarih;
        this.miktar = miktar;
        this.siparisDurum = siparisDurum;
    }

    public Siparis(String kisiAdi, String tarih, String miktar, int siparisDurum, long neZaman) {
        this.kisiAdi = kisiAdi;
        this.tarih = tarih;
        this.miktar = miktar;
        this.siparisDurum = siparisDurum;
        this.neZaman = neZaman;
    }

    public String getKisiAdi() {
        return kisiAdi;
    }

    public String getTarih() {
        return tarih;
    }

    public String getMiktar() {
        return miktar;
    }

    public int getSiparisDurum() {
        return siparisDurum;
    }

    public long getNeZaman() {
        return neZaman;
    }
}
/*
public class Post {

    public String uid;
    public String author;
    public String title;
    public String title_author;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String title_author, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.title_author = title_author;
        this.body = body;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("title_author", title_author);
        result.put("body", body);
        result.put("starCount", starCount);
        result.put("stars", stars);

        return result;
    }
    // [END post_to_map]

}
 */