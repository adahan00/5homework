package com.example.hm50;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContViewHolder> {

    Context context;
    ArrayList<Contact> name;
    private OnClick onClick;

    public ContactAdapter(ArrayList<Contact> name, OnClick onClick) {
        this.name = name;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ContViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cont, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContViewHolder holder, int position) {
        holder.bind(name.get(position), context);
        holder.itemView.setOnClickListener(v -> {
            onClick.onClick(name.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ContViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;

        public ContViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image_continent);

        }

        public void bind(Contact contact, Context context) {
            name.setText(contact.getName());
            Glide.with(context).load(contact.getImage()).into(image);
        }
    }
}
