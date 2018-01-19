package com.example.asus.olxtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.olxtest.adapter.SimpleFragmentPagerAdapter;



public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        TabLayout sliding_tabs = (TabLayout) findViewById(R.id.sliding_tabs);
        ViewPager viewpager = (ViewPager)findViewById(R.id.viewpager);

        sliding_tabs.setupWithViewPager(viewpager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this,getSupportFragmentManager());
        viewpager.setAdapter(adapter);
    }
}
