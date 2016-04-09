package com.gaolonglong.app.tabindicator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Indicator indicator;
    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> list;
    private TextView homeTab,radioTab,rankingTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

        initEvent();
    }

    private void initEvent() {
        //Listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("666",position+"...."+positionOffset);
                indicator.scroll(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //Click
        homeTab.setOnClickListener(this);
        radioTab.setOnClickListener(this);
        rankingTab.setOnClickListener(this);
    }

    private void initView() {
        //View
        indicator = (Indicator) findViewById(R.id.indicator);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        homeTab = (TextView) findViewById(R.id.home_tab);
        radioTab = (TextView) findViewById(R.id.radio_tab);
        rankingTab = (TextView) findViewById(R.id.ranking_tab);
        //List
        list = new ArrayList<Fragment>();
        list.add(new HomeFragment());
        list.add(new RadioFragment());
        list.add(new RankingFragment());
        //Adapter
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };

        viewPager.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_tab:
                homeTab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio_tab:
                homeTab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ranking_tab:
                homeTab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(2);
                break;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
