package com.example.muhammadshoaib.mymosque.Retrofit;
import com.example.muhammadshoaib.mymosque.POJOClasses.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {




    @GET("getMosquesList/33")
    Call<MasjidArrayList> getInfo(@Query("page") int page);



}
