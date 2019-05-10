package com.example.muhammadshoaib.mymosque.POJOClasses;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class MainModel {

    @SerializedName("data")
    private JsonArray data;

    @SerializedName("links")
    private JsonObject links;

    @SerializedName("meta")
    private JsonObject meta;

    public JsonArray getData() {
        return data;
    }

    public JsonObject getLinks() {
        return links;
    }

    public JsonObject getMeta() {
        return meta;
    }
}
