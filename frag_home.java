package com.example.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class frag_home extends Fragment {
    String api="7e536c612e2e494c8bbc846076b5f13b";
    ArrayList<ModelClass> modelClassArrayList;
    recycleView_adapter adapter;
    String country="in";
    private RecyclerView recyclerViewofhome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View v= inflater.inflate(R.layout.fragment_home,null);
        recyclerViewofhome=v.findViewById(R.id.recycle_home);
        modelClassArrayList=new ArrayList<>();
        recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
       adapter = new recycleView_adapter(getContext(), modelClassArrayList);
        recyclerViewofhome.setAdapter(adapter);
        findNews(country);

        return v;
    }

    void findNews(String country) {
        ApiUtilities.getApiInterface().getNews(country, String.valueOf(20),api).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                   if(response.isSuccessful()){
                       modelClassArrayList.addAll(response.body().getArticles());
                       adapter.notifyDataSetChanged();
                   }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
