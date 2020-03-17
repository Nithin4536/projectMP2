package com.example.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class firstFragment extends Fragment {


    RecycleAdapter adapter;
    ArrayList<drink_> darray;



    public firstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataservice service = RetrofitClientInstance.getRetrofitInstance().create(dataservice.class);

        Call<drink> call = service.getAllDrink();

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

        adapter = new RecycleAdapter(darray, getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

}