package com.example.navigationdrawerhometask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class AdapterForRecycler extends RecyclerView.Adapter<AdapterForRecycler.MyViewHolder> {


    private ArrayList<Members> membersList;
    private OnNoteListner onNoteListnerTwo;

    public AdapterForRecycler(ArrayList<Members> list,OnNoteListner onNoteListner)
    {
        this.membersList= list;
        this.onNoteListnerTwo=onNoteListner;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);

        return new MyViewHolder(view,onNoteListnerTwo);
    }

    // 0,1,2,3
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(membersList.get(position).getName());
        int age=membersList.get(position).getAge();
        holder.age.setText(String.valueOf(age));
        holder.status.setText(membersList.get(position).getStatus().toString());
    }

    @Override
    public int getItemCount() {
        if(membersList==null)
            return 0;
        return membersList.size();
    }



    public void setPatientsList(ArrayList<Members> patientsList) {
        this.membersList = patientsList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        //public BreakIterator age;
        TextView name,age,status;
        OnNoteListner onNoteListner;

        public MyViewHolder(@NonNull View itemView,OnNoteListner onNoteListner) {
            super(itemView);
            name=itemView.findViewById(R.id.Rname);
            age=itemView.findViewById(R.id.Rage);
            status=itemView.findViewById(R.id.RStatus);
            this.onNoteListner=onNoteListner;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            onNoteListner.onNoteclick(getAdapterPosition());
        }
    }

    public interface OnNoteListner{
        void onNoteclick(int position);
    }
}
