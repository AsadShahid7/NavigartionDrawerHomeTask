package com.example.navigationdrawerhometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;

public class Add_New_Record extends AppCompatActivity implements  AdapterForRecycler.OnNoteListner {

    EditText name,age;
    Switch aSwitch;
    ArrayList<Members> listMembers;
    RecyclerView recyclerView;
    ConstraintLayout layout1,layout2;

    //RecyclerView.Adapter<> adapterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new__record);
        name=findViewById(R.id.editTextPersonName);
        age=findViewById(R.id.editTextTextPersonName2);
        aSwitch=findViewById(R.id.switch1);
        listMembers=new ArrayList<>();
        recyclerView=findViewById(R.id.listRecycler);


    }

    public void addNewRecord(View view) {
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Members members=new Members();
        members.setName(name.getText().toString());
        members.setAge(Integer.parseInt(age.getText().toString()));
        Boolean check=false;
        if(aSwitch.isChecked())
        {
            check=true;
        }
        members.setStatus(check);

        listMembers.add(members);
        AdapterForRecycler adapter = new AdapterForRecycler(listMembers,this);
        recyclerView.setAdapter(adapter);
        adapter.setPatientsList(listMembers);
    }

    @Override
    public void onNoteclick(int position) {

    }

    public void showAllRecords(View view) {
        layout1=findViewById(R.id.formLayout);
        layout1.setVisibility(View.GONE);
        layout2=findViewById(R.id.recyclerLayoutAddRecord);
        layout2.setVisibility(View.VISIBLE);
    }

    public void goBack(View view) {
        layout1=findViewById(R.id.formLayout);
        layout1.setVisibility(View.VISIBLE);
        layout2=findViewById(R.id.recyclerLayoutAddRecord);
        layout2.setVisibility(View.GONE);
    }
}