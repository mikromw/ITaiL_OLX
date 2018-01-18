package com.example.asus.olxtest.adapter;

/**
 * Created by ASUS on 10/5/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.asus.olxtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("Sepeda baru");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Laptop baru");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Kulkas Masih mulus");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Sepeda bekas");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("AC LG masih dingin");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Handphone Samsung Masih Mulus");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Ban Bekas Masih Tebal");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Laptop Bekas");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Laptop Bekas");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);


        nama = new EndangeredItem();
        nama.setName("Laptop Bekas");
        nama.setThumbnail(R.drawable.back);
        mItems.add(nama);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        ImageView imgThumbnail;
        TextView tvspecies;

        ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.img_thumnail);
            tvspecies = itemView.findViewById(R.id.harga);

        }
    }
}
