package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.emart.Adapters.StudyAdapter;
import com.example.emart.Adapters.StudyAdapter1;
import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel;
import com.example.emart.Models.StudyModel1;

import java.util.ArrayList;

public class FirstFeetCourses extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_feet_courses);

        recyclerView = findViewById(R.id.recyclerView1);

        ArrayList<StudyModel1> list = new ArrayList<>();
        list.add(new StudyModel1(R.drawable.playgroup ,"Play Group"));
        list.add(new StudyModel1(R.drawable.playgroupafter ,"Nursary"));
        list.add(new StudyModel1(R.drawable.juniourkg ,"junior KG"));
        list.add(new StudyModel1(R.drawable.hkg ,"senior KG"));


        StudyAdapter1 adapter = new StudyAdapter1(list,this);
        recyclerView.setAdapter(adapter);

        //StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        //recyclerView.setLayoutManager(staggered);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Intent intent = new Intent(FirstFeetCourses.this,PlayGroup.class);
                                startActivity(intent);

                                break;

                            case 1:
                                Intent i = new Intent(FirstFeetCourses.this,Nursary.class);
                                startActivity(i);

                                break;

                            case 2:
                                Intent i1 = new Intent(FirstFeetCourses.this,JuniorKg.class);
                                startActivity(i1);

                                break;

                            case 3:
                                Intent i2 = new Intent(FirstFeetCourses.this,SeniorKg.class);
                                startActivity(i2);

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