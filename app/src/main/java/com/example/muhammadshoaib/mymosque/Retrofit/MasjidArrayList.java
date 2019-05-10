package com.example.muhammadshoaib.mymosque.Retrofit;

import com.example.muhammadshoaib.mymosque.POJOClasses.LinksModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MasjidModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MasjidArrayList {


    @SerializedName("data")
    private ArrayList<MasjidModel> masjidModelArrayList;

   /* @SerializedName("links")
    private ArrayList<LinksModel> linksModelArrayList;*/


    public ArrayList<MasjidModel> getMasjidModelArrayList() {
        return masjidModelArrayList;
    }


   /* public ArrayList<LinksModel> getLinksModelArrayList() {
        return linksModelArrayList;
    }*/
}
