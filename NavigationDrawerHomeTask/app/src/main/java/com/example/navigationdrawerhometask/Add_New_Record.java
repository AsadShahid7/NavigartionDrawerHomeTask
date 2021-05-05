package com.example.navigationdrawerhometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_New_Record extends AppCompatActivity implements  AdapterForRecycler.OnNoteListner {

    EditText name,age;
    Switch aSwitch;
    ArrayList<Members> listMembers;

    RecyclerView recyclerView;
    ConstraintLayout layout1,layout2;
    final CharSequence[] colors = { "Student", "Teacher", "Worker", "Parent" };
    ArrayList<Integer> slist = new ArrayList();
    boolean icount[] = new boolean[colors.length];
    String msg ="";

    //recyclerView.Adapter<> adapterView;
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

    public void showMultiDialoge(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Add_New_Record.this);
        builder.setTitle("Choose Colors")
                .setMultiChoiceItems(colors,icount, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
                        if (arg2) {
                            slist.add(arg1);
                        } else if (slist.contains(arg1)) {
                            slist.remove(Integer.valueOf(arg1));
                        }
                    }
                })      .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        msg = "";
                        for (int i = 0; i < slist.size(); i++) {
                            msg = msg + "\n" + (i + 1) + " : " + colors[slist.get(i)];
                        }
                        Toast.makeText(getApplicationContext(), "Total " + slist.size() + " Items Selected.\n" + msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Add_New_Record.this,"No Option Selected",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();

    }
}