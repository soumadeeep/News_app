package com.example.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class frag_stock extends Fragment {
    String api="7e536c612e2e494c8bbc846076b5f13b";
    ArrayList<ModelClass> modelClassArrayList;
    recycleView_adapter adapter;
    String country="in";
    String category= "business";
    private RecyclerView recyclerViewofstock;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View v= inflater.inflate(R.layout.fragment_stock,null);
        recyclerViewofstock=v.findViewById(R.id.recycle_stock);
        modelClassArrayList=new ArrayList<>();
        recyclerViewofstock.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new recycleView_adapter(getContext(), modelClassArrayList);
        recyclerViewofstock.setAdapter(adapter);
        findNews();

        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category, String.valueOf(20),api).enqueue(new Callback<MainNews>() {
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
