package com.example.mieib.andora;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class Detailes extends Fragment {


    ImageView imageView;
    TextView textView;
    ImageButton imageButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailes, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView)view.findViewById(R.id.details_text_item);
        imageView = (ImageView)view.findViewById(R.id.details_image_item);

        String url = getArguments().getString("url");
        int position = getArguments().getInt("position");

        Picasso.with(getContext()).load(url).placeholder(R.drawable.ic_image).into(imageView);

        if((position)%3==1){
           textView.setText("%25");
            textView.setTextColor(Color.RED);
        }else  if((position)%3==2){
           textView.setText("%10");
           textView.setTextColor(Color.RED);
        }

        imageButton = (ImageButton)view.findViewById(R.id.details_shope_this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MainActivity mainActivity =(MainActivity) getActivity();
               mainActivity.buy();

            }
        });


    }
}
