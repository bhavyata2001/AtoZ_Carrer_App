package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.emart.Adapters.StudyAdapter4;
import com.example.emart.Adapters.StudyAdapter5;
import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel4;
import com.example.emart.Models.StudyModel5;

import java.util.ArrayList;

public class WorkFromHome extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_from_home);

        recyclerView = findViewById(R.id.recyclerview5);
        ArrayList<StudyModel5> list = new ArrayList<>();

        list.add(new StudyModel5(R.drawable.camdel, "Candel Making Business"));
        list.add(new StudyModel5(R.drawable.dataentry, "Data Entry Oprator"));
        list.add(new StudyModel5(R.drawable.coaching, "Coaching classes"));
        list.add(new StudyModel5(R.drawable.cw, "Content Writer"));
        list.add(new StudyModel5(R.drawable.software, "Software Devloper"));

        StudyAdapter5 adapter = new StudyAdapter5(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();

                                break;

                            case 3:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();

                                break;
                            case 4:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();

                                break;
                            case 5:
                                Toast.makeText(WorkFromHome.this,"Available in all city.",Toast.LENGTH_SHORT).show();

                                break;
                            default:
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }

                ));
    }
}