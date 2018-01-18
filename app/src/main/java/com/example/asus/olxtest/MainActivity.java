package com.example.asus.olxtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.asus.olxtest.Tab.SlidingTabLayout;
import com.example.asus.olxtest.fragment.CameraFragment;
import com.example.asus.olxtest.fragment.ChatFragment;
import com.example.asus.olxtest.fragment.ExploreFragment;
import com.example.asus.olxtest.fragment.FriendFragment;
import com.example.asus.olxtest.fragment.Home;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorAccent)
                .withTextColor(R.color.md_black_1000)
                .withTextColorRes(R.color.md_black_1000)
                .addProfiles(
                        new ProfileDrawerItem().withName("OLX Android").withEmail("Itail@gmail.com").withIcon(getResources().getDrawable(R.drawable.back))
                )
                .build();
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggle(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withStatusBarColor(R.color.colorPrimary)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();
        navigationDrawerLeft.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                switch (position){
                    case 1:
                        Intent intent = new Intent(MainActivity.this, Profil.class);
                        startActivity(intent);

                }
            }
        });
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Profil Saya").withIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Iklan Saya").withIcon(getResources().getDrawable(R.drawable.ic_dashboard_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Saldo OLX").withIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Hubungi kami").withIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Tentang OLX").withIcon(getResources().getDrawable(R.drawable.ic_textsms_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Info Aplikasi").withIcon(getResources().getDrawable(R.drawable.ic_search_black_48dp)));

        bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            Fragment fragment = null;
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if(tabId == R.id.tab_home){
                    fragment = new Home();
                }else if(tabId == R.id.tab_explore){
                    fragment = new ExploreFragment();
                }else if(tabId == R.id.tab_camera){
                    fragment = new CameraFragment();
                }else if(tabId == R.id.tab_chat){
                    fragment = new ChatFragment();
                }else if(tabId == R.id.tab_friends){
                  fragment = new FriendFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }




    }

