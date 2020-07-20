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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayGroup extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_group);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlayGroup.this,PlayGroupCourse.class);
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
                    Toast.makeText(PlayGroup.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("PlayShaala Pre School And Day Care Centre, Visit link:http://www.playshaala.in/", 1));
        data.add(new ComicBody("G D Goenka Toddler House Adajan, Visit: +919021118325", 1));
        data.add(new ComicBody("Euro Kids, Visit link:http://www.eurokidsindia.com/", 1));
        data.add(new ComicBody("Little Millennium , Visit link:http://www.littlapreschool.com", 1));
        data.add(new ComicBody("Hello Kids ,Visit link:http://www.hellokidssurat.in/", 1));
        data.add(new ComicBody("Podar Jumbo Kids ,Visit link:https://www.jumbokids.com/", 1));

        data.add(new ComicBody("WOW KIDS, Visit link:http://www.wowkids.in/", 2));
        data.add(new ComicBody("Kidzee, Visit link:http://www.kidzeenewchandkheda.in/", 2));
        data.add(new ComicBody("Smart Kidz, Visit link:http://www.smartkidzindia.com", 2));
        data.add(new ComicBody("Euro Kids,Visit link:http://www.eurokidsindia.com", 2));
        data.add(new ComicBody("Lil Penguinz, Visit link:http://www.facebook.com/lilpenguinzpreschool", 2));
        data.add(new ComicBody("Khyati Ninos, Visit link:http://www.facebook.com/khyatininospaldi", 2));

        data.add(new ComicBody("SMARTKiDZ Play School, Visit link:https://www.smartkidzindia.com/", 3));
        data.add(new ComicBody("Rangoli Preschools, Visit link:https://www.rangolischool.co.in", 3));
        data.add(new ComicBody("Sunrise International Preschool, Visit link:http://www.sunrisepreschool.in/", 3));
        data.add(new ComicBody("Euro Kids, Visit link:http://www.eurokidsindia.com", 3));
        data.add(new ComicBody("Mini Miracles, Visit link:http://www.minimiraclesgandhinagar.com", 3));
        data.add(new ComicBody("Smartkidz Playschool, Visit link:http://www.smartkidzindia.com/", 3));

        data.add(new ComicBody("The American Schoo, Visit link:https://www.theamericanschool.org/", 4));
        data.add(new ComicBody("Eurokids, Visit link:https://www.eurokidsindia.com/", 4));
        data.add(new ComicBody("Kidzee, Visit link:https://www.kidzee.com/", 4));
        data.add(new ComicBody("Shanti Juniors, Visit link:http://www.shantijuniors.com/", 4));
        data.add(new ComicBody("Bachpan, Visit link:https://www.bachpanglobal.com/", 4));
        data.add(new ComicBody("Hello Kids Preschool, Visit link:https://www.hellokids.co.in/", 4));

        data.add(new ComicBody("Little Millennium , Visit link:http://www.littlapreschool.com", 5));
        data.add(new ComicBody("Eurokids, Visit link:https://www.eurokidsindia.com/", 5));
        data.add(new ComicBody("Smartkidz Playschool, Visit link:http://www.smartkidzindia.com/", 5));
        data.add(new ComicBody("Acharya Academy, Visit link:http://www.acharya-academy.com/", 5));
        data.add(new ComicBody("Bachpan, Visit link:https://www.bachpanglobal.com/", 5));
        data.add(new ComicBody("Sun Flower Preschool, Visit link:http://www.sunflowerpreschool.co.in", 5));

        data.add(new ComicBody("Eurokids, Visit link:https://www.eurokidsindia.com/", 6));
        data.add(new ComicBody("Eklavya Public School , Visit link:http://www.http://eklavyakids.org/", 6));
        data.add(new ComicBody("Chubby Cheeks preschool, Visit link:http://www.chubbycheekspreschool.com/", 6));
        data.add(new ComicBody("Krishna Primary School, Visit link:https://www.admission24/krishna-primary-school.com/", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(PlayGroup.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody1{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody1(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
