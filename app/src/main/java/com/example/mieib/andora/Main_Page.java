package com.example.mieib.andora;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Main_Page extends Fragment {


    TextView men;
    TextView women;
    TextView kids;
    Category_Swithcher category_swithcher;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        men = (TextView)view.findViewById(R.id.men);
        women = (TextView)view.findViewById(R.id.women);
        kids = (TextView)view.findViewById(R.id.kids);

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_swithcher.select_category("men");
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_swithcher.select_category("women");
            }
        });

        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_swithcher.select_category("kids");
            }
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category_swithcher = (Category_Swithcher)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main__page, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
