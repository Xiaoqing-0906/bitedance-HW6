package com.app.keepdog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.time.temporal.ValueRange;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHoldel> {
    private List<DogItem> list;
    private MyOnClickListener listener;
    private Context context;

    public void setListener(MyOnClickListener listener) {
        this.listener = listener;
    }

    public MainAdapter(Context context,List<DogItem> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_main, null);
        return new MainHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHoldel holder, int position) {
        DogItem item = list.get(position);

        Glide.with(context).load(item.icon).into(holder.itemIcon);
        holder.tvName.setText(item.name);
        holder.tvContent.setText(item.content);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainHoldel extends RecyclerView.ViewHolder{

        private final ImageView itemIcon;
        private final TextView tvName,tvContent;

        public MainHoldel(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.item_iv);
            tvName = itemView.findViewById(R.id.tvName);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }

    public interface MyOnClickListener{
        void onClick(int position);
    }
}
