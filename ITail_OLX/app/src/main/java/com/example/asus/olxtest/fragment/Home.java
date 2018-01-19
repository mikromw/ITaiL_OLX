package com.example.asus.olxtest.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.asus.olxtest.R;
import com.example.asus.olxtest.adapter.Data;
import com.example.asus.olxtest.adapter.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Home extends Fragment {
    private String URL ="https://pembuatanprogram.000webhostapp.com/produk.php";
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    private ArrayList<Data> listData;
    RecyclerView.LayoutManager layoutManager;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        listData = new ArrayList<Data>();
        AmbilData();
        recyclerAdapter = new RecyclerAdapter(getActivity(), listData);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

        return view;

    }

    public void AmbilData(){
        JsonArrayRequest aarRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject data = response.getJSONObject(i);
                                    Data item = new Data();
                                    item.setId(data.getString("id"));
                                    item.setJudul(data.getString("judul"));
                                    item.setHarga(data.getString("harga"));
                                    item.setThubnail(URL + "/img/" + data.getString("gambar"));
                                    listData.add(item);
                                    recyclerAdapter.notifyDataSetChanged();
                                } catch (JSONException e) {

                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

        };
        Volley.newRequestQueue(getActivity()).add(aarRequest);
    }




}
