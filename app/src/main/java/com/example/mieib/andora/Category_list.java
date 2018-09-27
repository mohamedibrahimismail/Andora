package com.example.mieib.andora;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Category_list extends Fragment {

    RecyclerView recyclerView;

    String[] men_url = {"http://isca-eg.com/task/men/1.jpg","http://isca-eg.com/task/men/2.jpg","http://isca-eg.com/task/men/3.jpg"
            ,"http://isca-eg.com/task/men/4.jpg","http://isca-eg.com/task/men/5.jpg","http://isca-eg.com/task/men/6.jpg"
            ,"http://isca-eg.com/task/men/7.jpg","http://isca-eg.com/task/men/8.jpg","http://isca-eg.com/task/men/9.jpg"};

    String[] women_url = {"http://isca-eg.com/task/women/1.jpg","http://isca-eg.com/task/women/2.jpg","http://isca-eg.com/task/women/3.jpg"
            ,"http://isca-eg.com/task/women/4.jpg","http://isca-eg.com/task/women/5.jpg","http://isca-eg.com/task/women/6.jpg"
            ,"http://isca-eg.com/task/women/7.jpg","http://isca-eg.com/task/women/8.jpg","http://isca-eg.com/task/women/9.jpg"};

    String[] kids_url = {"http://isca-eg.com/task/kids/1.jpg","http://isca-eg.com/task/kids/2.jpg","http://isca-eg.com/task/kids/3.jpg"
            ,"http://isca-eg.com/task/kids/4.jpg","http://isca-eg.com/task/kids/5.jpg","http://isca-eg.com/task/kids/6.jpg"
            ,"http://isca-eg.com/task/kids/7.jpg","http://isca-eg.com/task/kids/8.jpg","http://isca-eg.com/task/kids/9.jpg"};

    String[] images=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String mParam1=null;
        if (getArguments() != null) {
            mParam1 = getArguments().getString("category");
        }
        if(mParam1.equals("men")){
            images = men_url;
        }else if(mParam1.equals("women")){
            images = women_url;
        }else if(mParam1.equals("kids")){
            images = kids_url;
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        Adapter adapter = new Adapter(images,getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);


         }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_list, container, false);
    }




}
