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

public class Science extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this,SscCourse.class);
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
                    Toast.makeText(Science.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Fountainhead School", 1));
        data.add(new ComicBody("P. P. Savani Cambridge International School", 1));
        data.add(new ComicBody("Podar International School", 1));
        data.add(new ComicBody("S.D. Jain Modern School", 1));
        data.add(new ComicBody("G.D. Goenka International School", 1));
        data.add(new ComicBody("L.P. Savani International", 1));
        data.add(new ComicBody("J.H. Ambani Saraswati Vidya Mandir", 1));
        data.add(new ComicBody("Shardayatan School", 1));
        data.add(new ComicBody("Delhi Public School", 1));
        data.add(new ComicBody("Lourdes Convent High School", 1));
        data.add(new ComicBody("Sheth Dhanjisha Rustamji Umrigar Memorial School", 1));

        data.add(new ComicBody("Ahmedabad International School (AIS)", 2));
        data.add(new ComicBody("Sant Kabir School", 2));
        data.add(new ComicBody("Mahatma Gandhi International School", 2));
        data.add(new ComicBody("Maharaja Agrasen Vidyalaya", 2));
        data.add(new ComicBody("Cosmos Castle International School", 2));
        data.add(new ComicBody("Anand Niketan School", 2));
        data.add(new ComicBody("Delhi Public School", 2));
        data.add(new ComicBody("Eklavya School", 2));
        data.add(new ComicBody("Udgam School", 2));

        data.add(new ComicBody("Ahmedabad Public School", 3));
        data.add(new ComicBody("BAPS Swaminarayan Vidyamandir", 3));
        data.add(new ComicBody("Delhi Public School ", 3));
        data.add(new ComicBody("Gandhinagar International Public School - GIPS", 3));
        data.add(new ComicBody("Jawahar Navodaya Vidyalaya", 3));
        data.add(new ComicBody("Kendriya Vidyalaya", 3));
        data.add(new ComicBody("Mahapragya Vidya Niketan ", 3));

        data.add(new ComicBody("St. Kabir Indian International School - Chapad - Vadodara", 4));
        data.add(new ComicBody("Delhi Public School", 4));
        data.add(new ComicBody("Green Valley High", 4));
        data.add(new ComicBody("Jawahar Navodaya Vidyalaya ", 4));
        data.add(new ComicBody("Kendriya Vidyalaya", 4));
        data.add(new ComicBody("Anandalaya", 4));
        data.add(new ComicBody("Navrachana Hr Sec School", 4));
        data.add(new ComicBody("Vibgyor High", 4));
        data.add(new ComicBody("Billabong High International School", 4));
        data.add(new ComicBody("Anand Vidya Vihar", 4));

        data.add(new ComicBody("S.N. Kansagra School", 5));
        data.add(new ComicBody("Modi School", 5));
        data.add(new ComicBody("St. Paul'S School", 5));
        data.add(new ComicBody("Kendriya Vidyalaya School", 5));
        data.add(new ComicBody("Shree K. G. Dholakiya School", 5));
        data.add(new ComicBody("Rajkot International School", 5));

        data.add(new ComicBody("Kendriya Vidyalaya", 6));
        data.add(new ComicBody("Eklavya Global School", 6));
        data.add(new ComicBody("Podar International School", 6));
        data.add(new ComicBody("Nobel High School", 6));
        data.add(new ComicBody("Alpha High School", 6));
        data.add(new ComicBody("Jawahar Navodaya Vidyalaya", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(Science.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody8{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody8(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
