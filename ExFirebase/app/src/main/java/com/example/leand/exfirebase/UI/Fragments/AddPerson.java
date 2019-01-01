package com.example.leand.exfirebase.UI.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leand.exfirebase.R;
import com.example.leand.exfirebase.UI.Model.MyApplication;
import com.example.leand.exfirebase.UI.Model.Person;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPerson extends Fragment {

    private EditText etName;
    private EditText etAge;
    private Button btOK;

    private MyApplication myApplication;
    private DatabaseReference bank; //Referencia do banco

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_add_person, container, false);
        init(view);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (etName.getText().toString().isEmpty()) {
                etName.setError("Invalid field");
                return;
            }

            if (etAge.getText().toString().isEmpty()) {
                etAge.setError("Invalid field");
                return;
            }

            Person person = new Person();
            person.setName(etName.getText().toString());
            person.setAge(etAge.getText().toString());

            bank.push().setValue(person);

            etName.getText().clear();
            etAge.getText().clear();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myApplication = new MyApplication();
        //Criando um nó na tabela do banco
        bank = FirebaseDatabase.getInstance().getReference("Persons");
    }

    private void init(View view) {

        etName = view.findViewById(R.id.fra_et_name);
        etAge = view.findViewById(R.id.fra_et_age);
        btOK = view.findViewById(R.id.fra_bt_ok);
    }
}
