package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FashionCourse extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FashionCourse.this,HscCourse.class);
                startActivity(i);
            }
        });
        final String names[] = {"Choose city ", "Surat", "Ahmedabad", "Gandhinagar", "Vadodara", "Rajkot", "Junagadh"};

        sp2 = (Spinner) findViewById(R.id.sp2);
        sp2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names));

        lw1 = (ListView) findViewById(R.id.lw1);
        lw1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getComicBody()));

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position >= 0 && position < names.length) {
                    getSelectedCategoryData(position);
                } else {
                    Toast.makeText(FashionCourse.this, "not exist", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private ArrayList<ComicBody> getComicBody() {
        ArrayList<ComicBody> data = new ArrayList<>();
        data.clear();

        data.add(new ComicBody("ALT Training College", 1));
        data.add(new ComicBody("Auro University", 1));
        data.add(new ComicBody("Edit Institute of Designing", 1));
        data.add(new ComicBody("International Institute of Fashion Technology - IIFT ", 1));
        data.add(new ComicBody("JD Institute of Fashion Technology", 1));

        data.add(new ComicBody("Raffles Millennium International", 2));
        data.add(new ComicBody("National Institute Of Design (NID)", 2));
        data.add(new ComicBody("Design Development Academy", 2));
        data.add(new ComicBody("International Institute Of Fashion Design", 2));

        data.add(new ComicBody("National Institute of Fashion Technology", 3));
        data.add(new ComicBody("Karnavati University", 3));
        data.add(new ComicBody("National Institute of Design", 3));
        data.add(new ComicBody("National Institute of Fashion Technology", 3));

        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("The Maharaja Sayajirao University of Baroda (MSU, Baroda),", 4));
        data.add(new ComicBody("Navrachana University (NU, Vadodara)", 4));
        data.add(new ComicBody("National Institute of Fashion Technology", 4));
        data.add(new ComicBody("JD Institute of Fashion Technology", 4));

        data.add(new ComicBody("BrainZ Institute of Design Studies, Rajkot", 5));
        data.add(new ComicBody("Parsons School of Design", 5));

        data.add(new ComicBody("Kohinoor Technical Institute", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(FashionCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
        }else {
            for (ComicBody comicBody : getComicBody()){
                if (comicBody.getCatID() == catID){
                    comicBodies.add(comicBody);
                }
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,comicBodies);
        }
        lw1.setAdapter(adapter);
    }

}

class ComicBody15{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody15(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
