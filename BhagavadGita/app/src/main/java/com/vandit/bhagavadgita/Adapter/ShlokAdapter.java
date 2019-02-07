package com.vandit.bhagavadgita.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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

public class ShlokAdapter extends RecyclerView.Adapter<ShlokAdapter.MyHolder> {
    ArrayList<RecyclerBean> arrayList;

    public ShlokAdapter(ArrayList<RecyclerBean> arrayList) {
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
        holder.textView.setText(bean.getShlok());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout linearLayout;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.lladhyay);
            textView=itemView.findViewById(R.id.txtadhyay);
            textView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) textView.getLayoutParams();
            params.setMargins(0,0,0,0);
            textView.setLayoutParams(params);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(view.getContext(), ShlokActivity.class);
            intent.putExtra("spos",getAdapterPosition());
            intent.putExtra("apos",Shlok_listActivity.n);
            intent.putExtra("no_of_shlok",Shlok_listActivity.i);
            view.getContext().startActivity(intent);
        }
    }
}
