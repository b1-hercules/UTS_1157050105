package com.nginx.utsmobpro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ListPertandinganAdapter extends RecyclerView.Adapter<ListPertandinganAdapter.ListPertandinganViewHolder> {

    private Context context;
    private final LinkedList<ModelPertandingan> listPertandingan;

    public ListPertandinganAdapter(Context context, LinkedList<ModelPertandingan> listPertandingan) {
        this.context = context;
        this.listPertandingan = listPertandingan;
    }

    @Override
    public ListPertandinganViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pertandingan, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListPertandinganViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListPertandinganViewHolder holder, int position) {
        final ModelPertandingan mCurrent = listPertandingan.get(position);
        holder.tvTimSatu.setText(mCurrent.getTimSatu());
        holder.tvTimDua.setText(mCurrent.getTimDua());
        holder.logoTimSatu.setImageResource(mCurrent.getLogoTimSatu());
        holder.logoTimDua.setImageResource(mCurrent.getLogoTimDua());
        holder.away.setText("Away");
        holder.home.setText("Home");
        holder.tvVs.setText("VS");
    }

    @Override
    public int getItemCount() {
        return listPertandingan.size();
    }

    public class ListPertandinganViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTimSatu, tvTimDua, tvVs, home, away;
        private ImageView logoTimSatu, logoTimDua;

        final ListPertandinganAdapter mAdapter;

        public ListPertandinganViewHolder(View itemView, ListPertandinganAdapter adapter) {
            super(itemView);
            home = (TextView) itemView.findViewById(R.id.home);
            away = (TextView) itemView.findViewById(R.id.away);
            tvTimSatu = (TextView) itemView.findViewById(R.id.tv_tim_satu);
            tvTimDua = (TextView) itemView.findViewById(R.id.tv_tim_dua);
            tvVs = (TextView) itemView.findViewById(R.id.tv_vs);
            logoTimSatu = (ImageView) itemView.findViewById(R.id.logo_tim_satu);
            logoTimDua = (ImageView) itemView.findViewById(R.id.logo_tim_dua);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            ModelPertandingan element = listPertandingan.get(mPosition);

            Intent i = new Intent(context, DetailPertandingaanActivity.class);
            i.putExtra("namaTimSatu", element.getTimSatu());
            i.putExtra("namaTimDua", element.getTimDua());
            i.putExtra("logoTimSatu", element.getLogoTimSatu());
            i.putExtra("logoTimDua", element.getLogoTimDua());
            i.putExtra("deskripsi", element.getNews());
            context.startActivity(i);
            mAdapter.notifyDataSetChanged();
        }
    }


}
