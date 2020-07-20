package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emart.Adapters.StudyAdapter3;

import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel3;

import java.util.ArrayList;

public class Ssc extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc);

        recyclerView = findViewById(R.id.recyclerView3);
        ArrayList<StudyModel3> list = new ArrayList<>();

        list.add(new StudyModel3(R.drawable.diploma, "Diploma"));
        list.add(new StudyModel3(R.drawable.science, "Science"));
        list.add(new StudyModel3(R.drawable.comerce, "Commerce"));
        list.add(new StudyModel3(R.drawable.art, "Arts"));
        list.add(new StudyModel3(R.drawable.iti, "ITI"));
         StudyAdapter3 adapter = new StudyAdapter3(list,this);
         recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Intent intent = new Intent(Ssc.this,Diploma.class);
                                startActivity(intent);

                                break;

                            case 1:
                                Intent i = new Intent(Ssc.this,Science.class);
                                startActivity(i);

                                break;

                            case 2:
                                Intent i1 = new Intent(Ssc.this,Commerce.class);
                                startActivity(i1);

                                break;

                            case 3:
                                Intent i2 = new Intent(Ssc.this,Arts.class);
                                startActivity(i2);

                                break;

                            case 4:
                                Intent i3 = new Intent(Ssc.this,Iti.class);
                                startActivity(i3);

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