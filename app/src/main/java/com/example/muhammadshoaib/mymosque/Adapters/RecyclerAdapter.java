package com.example.muhammadshoaib.mymosque.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhammadshoaib.mymosque.POJOClasses.MasjidModel;
import com.example.muhammadshoaib.mymosque.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<MasjidModel> info;
    private Context context;

    public RecyclerAdapter(ArrayList<MasjidModel> info,Context context){


        this.info = info;
        this.context=context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_items,viewGroup,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        viewHolder.mosque_name.setText(info.get(i).getName());
        viewHolder.mosque_address.setText(info.get(i).getAddress());


        Picasso.with(context).load(info.get(i).getImageUrl()).into(viewHolder.mosque_image);

        if (info.get(i).getFarvoriate() == 1){


            viewHolder.favourite_image.setImageResource(R.drawable.like);

        }

        else {

            viewHolder.favourite_image.setImageResource(R.drawable.heart);
        }




    }

    @Override
    public int getItemCount() {
        return info.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mosque_image,favourite_image;
        TextView mosque_name,mosque_address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mosque_image=itemView.findViewById(R.id.mosque_image);
            mosque_name=itemView.findViewById(R.id.mosque_name);
            mosque_address=itemView.findViewById(R.id.mosque_address);
            favourite_image=itemView.findViewById(R.id.favourites_icon);




        }
    }
}
