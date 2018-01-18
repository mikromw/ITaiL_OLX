package com.example.asus.olxtest.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.olxtest.R;
import com.example.asus.olxtest.adapter.SimpleFragmentPagerAdapter;

/**
 * Created by ASUS on 10/3/2017.
 */

public class ChatFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private TabLayout tablayout;
    private ViewPager viewPager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        rootView.setTag(TAG);

        tablayout = rootView.findViewById(R.id.sliding_tabs);
        viewPager = rootView.findViewById(R.id.viewpager);

        tablayout.setupWithViewPager(viewPager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getActivity(),getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        return rootView;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER,null);
        super.onSaveInstanceState(savedInstanceState);
    }

}
