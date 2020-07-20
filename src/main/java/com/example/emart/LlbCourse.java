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

public class LlbCourse extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llb_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LlbCourse.this,HscCourse.class);
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
                    Toast.makeText(LlbCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("V.T. Choksi sarvajanik law college", 1));

        data.add(new ComicBody("Vivekanand College of Law", 2));
        data.add(new ComicBody("Sir L. A. Shah Law College", 2));
        data.add(new ComicBody("Nirma University", 2));
        data.add(new ComicBody("Nav Gujarat Law College", 2));
        data.add(new ComicBody("Motilal Nehru Law College", 2));
        data.add(new ComicBody("IM Nanavati Law College", 2));

        data.add(new ComicBody("Gujarat National Law University", 3));
        data.add(new ComicBody("Siddharth Law College", 3));
        data.add(new ComicBody("Shankersinh Vaghela Bapu Institute of Law", 3));
        data.add(new ComicBody("Samarpan School of Law", 3));
        data.add(new ComicBody("Gujarat Maritime University", 3));

        data.add(new ComicBody("Navrachana University", 4));
        data.add(new ComicBody("Maharaja Sayajirao University of Baroda", 4));

        data.add(new ComicBody("AMP Government Law College", 5));
        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("Shree HN Shukla College of Legal Studies", 5));
        data.add(new ComicBody("Smt RD Gardi College", 5));
        data.add(new ComicBody("Saurashtra University", 5));
        data.add(new ComicBody("SV Patel Law College", 5));

        data.add(new ComicBody("JJCET Law College", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(LlbCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody17{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody17(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}