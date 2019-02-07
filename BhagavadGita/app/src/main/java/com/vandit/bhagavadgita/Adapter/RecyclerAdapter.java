package com.vandit.bhagavadgita.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vandit.bhagavadgita.Model.RecyclerBean;
import com.vandit.bhagavadgita.R;
import com.vandit.bhagavadgita.ShlokActivity;
import com.vandit.bhagavadgita.Shlok_listActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    ArrayList<RecyclerBean> arrayList;

    public RecyclerAdapter(ArrayList<RecyclerBean> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_gita_adhyay,parent,false);
        MyHolder myHolder=new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        RecyclerBean bean=arrayList.get(position);
        holder.txtadyay.setText(bean.getAdhyay());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout lladhyay;
        TextView txtadyay;
        public MyHolder(View itemView) {
            super(itemView);
            lladhyay=itemView.findViewById(R.id.lladhyay);
            txtadyay=itemView.findViewById(R.id.txtadhyay);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(view.getContext(), Shlok_listActivity.class);
            intent.putExtra("pos",getAdapterPosition());
            view.getContext().startActivity(intent);
        }
    }
}
