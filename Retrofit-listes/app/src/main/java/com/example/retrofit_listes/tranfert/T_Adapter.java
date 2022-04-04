package com.example.retrofit_listes.tranfert;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_listes.R;
import com.example.retrofit_listes.tranfert.T_truc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class T_Adapter extends RecyclerView.Adapter<T_Adapter.MyViewHolder> {
    public List<T_truc> list;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TVtruc1;
        public TextView TVtruc2;
        public TextView TVtruc3;
        public MyViewHolder(LinearLayout v) {
            super(v);
            TVtruc1 = v.findViewById(R.id.textView1);
            TVtruc2 = v.findViewById(R.id.textView2);
            TVtruc3 = v.findViewById(R.id.textView3);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public T_Adapter() {
        list = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public T_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        Log.i("DEBOGAGE", "appel a onCreateViewHolder");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        T_truc elementCourant = list.get(position);
        LocalDateTime auj = LocalDateTime.now();
        holder.TVtruc1.setText(elementCourant.a);
        holder.TVtruc2.setText(elementCourant.b);
        holder.TVtruc3.setText(elementCourant.c.size()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Log.i("DEBOGAGE", "appel a onBindViewHolder " + position);
    }

    // renvoie la taille de la liste
    @Override
    public int getItemCount() {
        return list.size();
    }


}