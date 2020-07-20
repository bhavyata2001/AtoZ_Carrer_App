package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emart.Adapters.StudyAdapter1;
import com.example.emart.Adapters.StudyAdapter2;
import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel1;
import com.example.emart.Models.StudyModel2;

import java.util.ArrayList;

public class Schools extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        recyclerView = findViewById(R.id.recyclerView2);

        ArrayList<StudyModel2> list = new ArrayList<>();
        list.add(new StudyModel2(R.drawable.gseb,"GSEB Board"));
        list.add(new StudyModel2(R.drawable.cbsc,"CBSE Board"));

        StudyAdapter2 adapter = new StudyAdapter2(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Intent intent = new Intent(Schools.this,Gseb.class);
                                startActivity(intent);

                                break;

                            case 1:
                                Intent i = new Intent(Schools.this,Cbse.class);
                                startActivity(i);

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