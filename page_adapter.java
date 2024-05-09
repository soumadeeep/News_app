package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class page_adapter extends FragmentPagerAdapter {

    int tabcount;
    public page_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:{
               return new frag_home();
           }
           case 1:{
               return new frag_sports();
           }
           case 2:{
               return new frag_health();
           }
           case 3:{
               return new frag_science();
           }
           case 4:{
               return new frag_entertainment();
           }
           case 5:{
               return new frag_stock();
           }

           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
