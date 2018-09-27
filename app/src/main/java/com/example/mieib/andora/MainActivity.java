package com.example.mieib.andora;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements Category_Swithcher{

    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView counter_text;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();

        Main_Page main_page = new Main_Page();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment,main_page);
        fragmentTransaction.commit();


        counter_text = (TextView)findViewById(R.id.counter);
    }

    @Override
    public void select_category(String category) {
        if(check_network()){
        Toast.makeText(this,category,Toast.LENGTH_SHORT).show();
        Category_list category_list = new Category_list();
        Bundle bundle = new Bundle();
        bundle.putString("category", category);
        category_list.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment,category_list);
        fragmentTransaction.addToBackStack("main");
        fragmentTransaction.commit();
    }else {
            Toast.makeText(this,"please check connection",Toast.LENGTH_SHORT).show();
        }

    }


    public void ShowProductDetails(String url,int position){
      //  Toast.makeText(this,url+position,Toast.LENGTH_SHORT).show();
        if(check_network()){
        Detailes detailes = new Detailes();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        bundle.putInt("position",position);
        detailes.setArguments(bundle);
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment,detailes);
        fragmentTransaction.addToBackStack("details");
        fragmentTransaction.commit();
        }else {
            Toast.makeText(this,"please check connection",Toast.LENGTH_SHORT).show();
        }

    }

    public void buy(){
        counter++;
        counter_text.setText(counter+"");
        Toast.makeText(this,"successful added",Toast.LENGTH_SHORT).show();
    }

    public boolean check_network(){
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else{
            connected = false;
        }

        return connected;
    }


}
