package com.example.artikelwayang;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

    public class ListWayangAdapter extends RecyclerView.Adapter<ListWayangAdapter.ListViewHolder> {
        private ArrayList<Wayang> listWayang;
        private Context context;

        public ListWayangAdapter(ArrayList<Wayang> listwayang, Context context) {
            this.listWayang = listwayang;
            this.context = context;
        }

        @NonNull
        @Override
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_wayang, viewGroup, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
            final Wayang wayang= listWayang.get(position);

            Glide.with(holder.itemView.getContext())
                    .load(wayang.getPhoto())
                    .apply(new RequestOptions().override(55, 55))
                    .into(holder.imgPhoto);

            holder.tvName.setText(wayang.getName());
            holder.tvDetail.setText(wayang.getWayang_detail());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent pindah = new Intent(context, DetailActivity.class);
                    pindah.putExtra(DetailActivity.EXTRA_WAYANG,wayang);
                    pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(pindah);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listWayang.size();
        }

        class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName, tvDetail;

            ListViewHolder(View itemView) {
                super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvName = itemView.findViewById(R.id.tv_item_name);
                tvDetail = itemView.findViewById(R.id.tv_item_detail);
            }
        }
    }

