package com.example.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThirdFragment extends Fragment {

    RecycleAdapter3 adapter;
    ArrayList<drink_> darray;



    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataservice service = RetrofitClientInstance.getRetrofitInstance().create(dataservice.class);

        Call<drink> call = service.getDrinkIng();

        call.enqueue(new Callback<drink>() {
            @Override
            public void onResponse(Call<drink> call, Response<drink> response) {
                drink drink = response.body();
                try{
                    darray = new ArrayList<>(drink.getDrink());
                    genView(darray,view);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<drink> call, Throwable t) {

            }
        });
    }

    private void genView(ArrayList<drink_> darray, View view) {

        adapter = new RecycleAdapter3(darray, getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

}



