package com.example.muhammadshoaib.mymosque.Retrofit;
import com.example.muhammadshoaib.mymosque.POJOClasses.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {




    @GET("getMosquesList/33")
    Call<MasjidArrayList> getInfo();


}
