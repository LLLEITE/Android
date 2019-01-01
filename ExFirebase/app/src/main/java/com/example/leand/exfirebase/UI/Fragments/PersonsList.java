package com.example.leand.exfirebase.UI.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leand.exfirebase.R;
import com.example.leand.exfirebase.UI.MainActivity;
import com.example.leand.exfirebase.UI.Model.MyApplication;
import com.example.leand.exfirebase.UI.Model.Person;
import com.example.leand.exfirebase.UI.Model.PersonAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PersonsList extends Fragment {

    private RecyclerView rvPersons;
    private ArrayList<Person> persons;
    private PersonAdapter adapter;

    private MyApplication myApplication;
    private DatabaseReference bank; //Referencia do banco

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_persons_list, container, false);
        init(view);

        adapter.setOnItemClickListener(new PersonAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final AlertDialog.Builder msg = new AlertDialog.Builder(getContext());
                msg.setTitle("Description");
                msg.setMessage("Você ativou o alert");
                msg.setPositiveButton("Ok", null);
                msg.show();
            }

            @Override
            public void onItemLongClick(View v, int position) {
                Toast.makeText(getContext(), "Segurou", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        persons = new ArrayList<>();
        adapter = new PersonAdapter(getContext(), persons);

        myApplication = new MyApplication();
        //Criando um nó na tabela do banco
        bank = FirebaseDatabase.getInstance().getReference("Persons");

        bank.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                persons.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {

                    Person s = data.getValue(Person.class);
                    //s.setKey(data.getKey());
                    persons.add(s);
                } // fechar for

                adapter.notifyDataSetChanged(); //notifica adapter
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    private void init(View view) {

        rvPersons = view.findViewById(R.id.ma_rv_persons);
        rvPersons.setAdapter(adapter);
        rvPersons.setHasFixedSize(true);
        rvPersons.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
