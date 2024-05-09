package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private TabItem mhome, msports, mhealth, mscience, mentartainment, mstock;
    private page_adapter pageAdapter;
    private Toolbar mtoolbar;
    String api="7e536c612e2e494c8bbc846076b5f13b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);



        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sport);
        mhealth = findViewById(R.id.health);
        mscience = findViewById(R.id.science);
        mentartainment = findViewById(R.id.entertainment);
        mstock = findViewById(R.id.stock);

        ViewPager viewPager = findViewById(R.id.fragmant_container);
        tabLayout = findViewById(R.id.tab);

        pageAdapter = new page_adapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        new MenuInflater(this).inflate(R.menu.country_selection,menu);
        return super.onCreateOptionsMenu(menu);
    }
    frag_home fh= new frag_home();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.poland) {
            // Handle click on Poland menu item
            updateNewsForCountry("pl");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateNewsForCountry(String countryCode) {
        if (fh.isAdded()) {
            fh.findNews(countryCode);
        }
    }


}


