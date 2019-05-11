package com.example.muhammadshoaib.mymosque.Retrofit;

import com.example.muhammadshoaib.mymosque.POJOClasses.LinksModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MasjidModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MetaModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MasjidArrayList {


    @SerializedName("data")
    private ArrayList<MasjidModel> masjidModelArrayList;

    @SerializedName("links")
    private LinksModel linksModel;

    @SerializedName("meta")
    private MetaModel metaModel;



    public ArrayList<MasjidModel> getMasjidModelArrayList() {
        return masjidModelArrayList;
    }

    public LinksModel getLinksModel() {
        return linksModel;
    }

    public MetaModel getMetaModel() {
        return metaModel;
    }


}
