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

public class BscCourse extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BscCourse.this,HscCourse.class);
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
                    Toast.makeText(BscCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Auro University", 1));
        data.add(new ComicBody("Ambaba Commerce College", 1));
        data.add(new ComicBody("Shree Swami Atmanand Saraswati Institute of Technology", 1));
        data.add(new ComicBody("Sheth PT Mahila College", 1));
        data.add(new ComicBody("NSC-Navyug Science College", 1));
        data.add(new ComicBody("P.T.Sarvajanik College of Science", 1));

        data.add(new ComicBody("RG Shah Science College", 2));
        data.add(new ComicBody("CU Shah Science College", 2));
        data.add(new ComicBody("MG Science Institute", 2));
        data.add(new ComicBody("Gujarat Arts and Science College", 2));
        data.add(new ComicBody("Ahmedabad University", 2));

        data.add(new ComicBody("MG Science Institute", 3));
        data.add(new ComicBody("Shri Sahajanand Arts & Commerce College", 3));
        data.add(new ComicBody("Ganpat University", 3));
        data.add(new ComicBody("R.J. Shah Science College", 3));

        data.add(new ComicBody("Mahila Mahavidyalaya", 4));
        data.add(new ComicBody("Academy For International Management & International Study", 4));
        data.add(new ComicBody("Chanakya Vidhyapeeth", 4));
        data.add(new ComicBody("Sheth MC College of Dairy Science Anand", 4));
        data.add(new ComicBody("Navrachana University", 4));
        data.add(new ComicBody("H.C. Patel Arts and Commerce College", 4));

        data.add(new ComicBody("Lukhdhirji Engineering College", 5));
        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("AVPT College", 5));
        data.add(new ComicBody("JH Bhalodia Mahilla Commerce College", 5));
        data.add(new ComicBody("RR Patel Mahilla College", 5));
        data.add(new ComicBody("Shri M & N Virani Science College", 5));

        data.add(new ComicBody("Bahauddin Science College", 6));
        data.add(new ComicBody("Ghodasara College", 6));
        data.add(new ComicBody("Noble Group of Institutions (NGI)", 6));
        data.add(new ComicBody("Gyanbharti College Of Computer Science", 6));
        data.add(new ComicBody("Dr. Subhash Technical Campus (DSTC)", 6));
        data.add(new ComicBody("OM Engineering College (OEC)", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(BscCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody12{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody12(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
