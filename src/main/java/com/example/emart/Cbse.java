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

public class Cbse extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbse);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cbse.this,GsebAndCbscCourse.class);
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
                    Toast.makeText(Cbse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Tapti Valley International School, Visit link:http://www.taptivalleyschool.com", 1));
        data.add(new ComicBody("S D Jain Modern School, U M Road, Visit:http://www.sdjgroup.org/", 1));
        data.add(new ComicBody("T M Patel International School, Visit link: http://tmpatelschool.com", 1));
        data.add(new ComicBody("Ryan International School, Visit link:http://www.ryaninternationalschools.com", 1));
        data.add(new ComicBody("Kendriya Vidyalaya", 1));
        data.add(new ComicBody("Podar international school", 1));

        data.add(new ComicBody("Kendriya Vidyalaya , ChandkhedaAhmedabad", 2));
        data.add(new ComicBody("St Kabir school", 2));
        data.add(new ComicBody("Maharaja Agrasen Vidyalaya", 2));
        data.add(new ComicBody("Swastik Sattva Vikas", 2));
        data.add(new ComicBody("Anand Niketan", 2));
        data.add(new ComicBody("Udgam School", 2));

        data.add(new ComicBody("Kendriya Vidyalaya", 3));
        data.add(new ComicBody("Aadharshila School, Visit link:http://www.aadharshila.edu.in/", 3));
        data.add(new ComicBody("Ahmedabad Public School, Visit link:http://www.apsinternational.org/", 3));
        data.add(new ComicBody("St. Xaviers High School", 3));
        data.add(new ComicBody("Hillwoods School, Visit link:http://hillwoodsindia.org/", 3));
        data.add(new ComicBody("Jawahar Navodaya Vidyalaya - JNV Gandhinagar", 3));

        data.add(new ComicBody("Kendriya Vidyalaya", 4));
        data.add(new ComicBody("Podar World School", 4));
        data.add(new ComicBody("St. Kabir Indian International School", 4));
        data.add(new ComicBody("Aayal Public School", 4));
        data.add(new ComicBody("Shri Swami Vivekanand High School", 4));
        data.add(new ComicBody("Delhi Public School", 4));

        data.add(new ComicBody("Kendriya Vidyalaya", 5));
        data.add(new ComicBody("Shree Swaminayayan Gurukul", 5));
        data.add(new ComicBody("Nalanda Vidyalaya, Visit:02602426613", 5));
        data.add(new ComicBody("Delhi Public School", 5));
        data.add(new ComicBody("Genius Cambridge International School", 5));
        data.add(new ComicBody("Podar international school", 5));

        data.add(new ComicBody("Kendriya Vidyalaya", 6));
        data.add(new ComicBody("Jawahar Navodaya Vidyalaya", 6));
        data.add(new ComicBody("Podar international school", 6));
        data.add(new ComicBody("S B Gardi Cambridge International School", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(Cbse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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
class ComicBody5{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody5(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
