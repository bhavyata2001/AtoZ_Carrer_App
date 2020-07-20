package com.example.emart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emart.Adapters.StudyAdapter;
import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static com.example.emart.Classes.RecyclerItemClickListener.*;

public class HomeActivity extends AppCompatActivity {


   RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       ActionBar actionbar = getSupportActionBar();
       actionbar.setDisplayShowHomeEnabled(true);
       actionbar.setIcon(R.mipmap.ic_launcher);


        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<StudyModel> list = new ArrayList<>();
        list.add(new StudyModel(R.drawable.firstfeet ,"First Feet"));
        list.add(new StudyModel(R.drawable.school ,"Schools"));
        list.add(new StudyModel(R.drawable.after10th ,"After 10th"));
        list.add(new StudyModel(R.drawable.after12th ,"After 12th"));
        list.add(new StudyModel(R.drawable.housewife ,"Home To Work"));

        StudyAdapter adapter = new StudyAdapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Intent intent = new Intent(HomeActivity.this,FirstFeetCourses.class);
                                startActivity(intent);

                            break;

                            case 1:
                                Intent i = new Intent(HomeActivity.this,Schools.class);
                                startActivity(i);

                                break;

                            case 2:
                                Intent i1 = new Intent(HomeActivity.this,Ssc.class);
                                startActivity(i1);

                                break;

                            case 3:
                                Intent i2 = new Intent(HomeActivity.this,Hsc.class);
                                startActivity(i2);

                                break;

                            case 4:
                                Intent i3 = new Intent(HomeActivity.this,WorkFromHome.class);
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

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        //recyclerView.setLayoutManager(gridLayoutManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commanmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.account){
            startActivity(new Intent(this,ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(View view) {
        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        finish();
    }
}
