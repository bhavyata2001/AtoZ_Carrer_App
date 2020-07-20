package com.example.emart.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emart.Models.StudyModel;
import com.example.emart.Models.StudyModel1;
import com.example.emart.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudyAdapter1 extends RecyclerView.Adapter<StudyAdapter1.viewHolder> {

        ArrayList<StudyModel1> list;
        Context context;

        public StudyAdapter1(ArrayList<StudyModel1> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview1 , parent , false);
            return new viewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            StudyModel1 model = list.get(position);
            holder.imageView.setImageResource(model.getPic());
            holder.textView.setText(model.getText());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class viewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;
            public viewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.playgroup);
                textView = itemView.findViewById(R.id.text);
            }
        }


    }

