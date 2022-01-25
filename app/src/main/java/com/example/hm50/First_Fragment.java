package com.example.hm50;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class First_Fragment extends Fragment implements OnClick {

    private RecyclerView recyclerView;
    private ArrayList <Contact> list;
    private ContactAdapter adapter;
    final static String st = "id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new ContactAdapter(list, this);
        recyclerView.setAdapter(adapter);
        loadData();

    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new Contact("Australia",R.drawable.ic_australia,1));
        list.add(new Contact("North America",R.drawable.ic_north_america,2));
        list.add(new Contact("Europe",R.drawable.ic_ceu,3));
        list.add(new Contact("Antarctida",R.drawable.ic_coc,4));
        list.add(new Contact("South America",R.drawable.ic_csa,5));
        list.add(new Contact("Africa",R.drawable.ic_caf,6));
    }



    @Override
    public void onClick(Contact contact) {
        Bundle bundle = new Bundle();
        Fragment fragment  = new First_Fragment();
        bundle.putString(st, contact.getName());
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}