package com.example.muhammadshoaib.mymosque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.muhammadshoaib.mymosque.Adapters.RecyclerAdapter;
import com.example.muhammadshoaib.mymosque.POJOClasses.LinksModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MainModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MasjidModel;
import com.example.muhammadshoaib.mymosque.Retrofit.ApiClient;
import com.example.muhammadshoaib.mymosque.Retrofit.ApiInterface;
import com.example.muhammadshoaib.mymosque.Retrofit.MasjidArrayList;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private MasjidArrayList info;
    private ApiInterface apiInterface;
    private List<MainModel> mainModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView = findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      recyclerView.setHasFixedSize(true);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);


        retrofit2.Call<MasjidArrayList> call = apiInterface.getInfo();

        call.enqueue(new Callback<MasjidArrayList>() {
            @Override
            public void onResponse(retrofit2.Call<MasjidArrayList> call, Response<MasjidArrayList> response) {

                //   Log.d("mosqueData"," "+ response.body());

                info=response.body();
                ArrayList<MasjidModel> mosqueData = response.body().getMasjidModelArrayList();



               // ArrayList<LinksModel> linksData =  response.body().getLinksModelArrayList();


                adapter = new RecyclerAdapter(mosqueData,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<MasjidArrayList> call, Throwable t) {
                Log.d("mosqueData"," "+ call);
            }
        });
    }





    }

