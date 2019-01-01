package com.example.leand.exfirebase.UI.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leand.exfirebase.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Person> persons;

    //1 - criar a interface
    public interface ClickListener{
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }

    //2 - criar o atributo clickListener
    private static ClickListener clickListener;

    public PersonAdapter(Context context, ArrayList<Person> p) {

        this.context = context;
        this.persons = p;
    }

    //3 - Implementar o View
    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private final TextView etName;
        private final TextView etAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            etName = itemView.findViewById(R.id.r_tv_name);
            etAge = itemView.findViewById(R.id.r_tv_age);

            //4 - setar os listeners
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //5 - enviar parametros
            clickListener.onItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {

            //6 - enviar parametros
            clickListener.onItemLongClick(v, getAdapterPosition());
            return true;
        }
    }

    //7 - método para acessar externamente de MainActivity
    public void setOnItemClickListener(ClickListener clickListener){
        PersonAdapter.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ViewHolder holder = (ViewHolder) viewHolder;

        Person person = persons.get(i);

        holder.etName.setText(person.getName());
        holder.etAge.setText(person.getAge());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
