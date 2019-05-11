package com.example.muhammadshoaib.mymosque;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.muhammadshoaib.mymosque.Adapters.RecyclerAdapter;
import com.example.muhammadshoaib.mymosque.POJOClasses.LinksModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MainModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MasjidModel;
import com.example.muhammadshoaib.mymosque.POJOClasses.MetaModel;
import com.example.muhammadshoaib.mymosque.Retrofit.ApiClient;
import com.example.muhammadshoaib.mymosque.Retrofit.ApiInterface;
import com.example.muhammadshoaib.mymosque.Retrofit.MasjidArrayList;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private MasjidArrayList info;
    private ApiInterface apiInterface;
    private List<MainModel> mainModels;
    private Boolean isScrolling = false;
    private int currentItems, totalItems, scrollOutItems;
    private ArrayList<MasjidModel> mosqueData;
    private MetaModel metaModel;
    private int pageNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        retrofit2.Call<MasjidArrayList> call = apiInterface.getInfo(1);

        call.enqueue(new Callback<MasjidArrayList>() {
            @Override
            public void onResponse(retrofit2.Call<MasjidArrayList> call, Response<MasjidArrayList> response) {

                //   Log.d("mosqueData"," "+ response.body());

                info = response.body();
                mosqueData = response.body().getMasjidModelArrayList();
                LinksModel linksModel = response.body().getLinksModel();
                d("link", "onResponse: " + linksModel);

                metaModel = response.body().getMetaModel();
                d("meta", " " + metaModel);


                d("mosqueData", " " + mosqueData);
                adapter = new RecyclerAdapter(mosqueData, MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(retrofit2.Call<MasjidArrayList> call, Throwable t) {
                d("mosqueData", " " + call);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            //this method will tell us that scrolling is started in recycler view
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){

                    isScrolling = true;

                    fetch_data();
                }




            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems = layoutManager.getChildCount();
                totalItems = layoutManager.getItemCount();
                scrollOutItems = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                d("scrollOut", " " + scrollOutItems);


                //this condition will check if user is scrolling and the total items have been displayed in recycler view
            if   (isScrolling && (currentItems + scrollOutItems == totalItems)) {

                 isScrolling = false;

                 // fetch data






           }


            }


        });


    }


    private void fetch_data(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                    final Call<MasjidArrayList> secondPageCall = apiInterface.getInfo(metaModel.getCurrent_page() + 1);

                  Log.d("pageNo"," " + pageNo);

                    secondPageCall.enqueue(new Callback<MasjidArrayList>() {
                        @Override
                        public void onResponse(Call<MasjidArrayList> call, Response<MasjidArrayList> response) {

                            MasjidArrayList masjidArrayList = response.body();
                            ArrayList<MasjidModel> secondPageData = response.body().getMasjidModelArrayList();


                            Log.d("secondPageData", secondPageData + " ");


                    /*   LinksModel SecondPageLinksModel = response.body().getLinksModel();
                        Log.d("SecondPageLink", "onResponse: "+SecondPageLinksModel);*/

                            metaModel = response.body().getMetaModel();
                            Log.d("SecondPageMeta", " " + metaModel);


                            for (int i = 0; i < secondPageData.size(); i++) {
                                mosqueData.add(secondPageData.get(i));


                            }

                            Log.d("finalList", " " + mosqueData);

                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onFailure(Call<MasjidArrayList> call, Throwable t) {

                        }
                    });


                }

        }, 3000);


    }



    }


