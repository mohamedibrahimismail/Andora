package com.example.mieib.andora;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{

    String[] urls;
    Context context;

    public Adapter(String[] images,Context mcontext) {
        urls = images;
        context = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String url = urls[i];
        viewHolder.url = url;
        Picasso.with(context).load(url).placeholder(R.drawable.ic_image).into(viewHolder.imageView);



     if((i)%3==1){
         viewHolder.textView.setText("%25");
         viewHolder.textView.setTextColor(Color.RED);
     }else  if((i)%3==2){
         viewHolder.textView.setText("%10");
         viewHolder.textView.setTextColor(Color.RED);
     }


    }

    @Override
    public int getItemCount() {
        return urls.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        ImageButton buy;
        String url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.image_item);
            textView = (TextView) itemView.findViewById(R.id.text_item);
            buy = (ImageButton)itemView.findViewById(R.id.shope_this);
            itemView.setOnClickListener(this);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity mainActivity = (MainActivity)context;
                    mainActivity.buy();
                }
            });


        }

        @Override
        public void onClick(View v) {
            MainActivity mainActivity = (MainActivity)context;
            mainActivity.ShowProductDetails(url,getAdapterPosition());
        }
    }



}
