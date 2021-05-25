package com.example.navigationdrawerhometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentMainActivity extends AppCompatActivity {


    Button fragmentOne,fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        fragmentOne=findViewById(R.id.buttonOne);
        fragmentTwo=findViewById(R.id.buttonTwo);

        fragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentOne());
            }
        });

        fragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentTwo());
            }
        });
    }
    public void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutInMain,fragment);
        fragmentTransaction.commit();
    }
}