package com.example.myapplication2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.ui.Job;

import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;

public class postsadapter extends RecyclerView.Adapter<postsadapter.postviewholder> {
    public ArrayList<Job> kuchbhi = new ArrayList();
    public postsadapter(ArrayList<Job> kuchbhi )
    {
        this.kuchbhi = kuchbhi;
    }


    @NonNull
    @Override
    public postviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(R.layout.multiple_posts,parent,false );
        return new postviewholder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull postviewholder holder, int position) {

        Job title = kuchbhi.get(position);
        holder.designation.setText(title.getDesignation());
        holder.company_name.setText(title.getCompany_name().replaceAll(".png", ""));
        holder.location_op.setText(title.getLocation());

        if (title.getCategory().equals("Internship")) {
            holder.img.setImageResource(R.drawable.pro_annoucement);
        }else if (title.getCategory().equals("Job | Full-time ")) {
            holder.img.setImageResource(R.drawable.student);
        }
        else {
            holder.img.setImageResource(R.drawable.star);
        }



        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("company_name",title.getCompany_name());
                intent.putExtra("designation",title.getDesignation());
                intent.putExtra("Qualification",title.getQualification());
                intent.putExtra("Location",title.getLocation());
                intent.putExtra("CtcOrStipend",title.getCtcOrStipend());
                intent.putExtra("designation",title.getDesignation());
                intent.putExtra("Ctc",title.getCtc());
                intent.putExtra("CandidateShouldHave",title.getCandidateShouldHave());
                intent.putExtra("CandidateShouldDescription1",title.getCandidateShouldDescription1());
                intent.putExtra("CandidateShouldDescription2",title.getCandidateShouldDescription2());
                intent.putExtra("CandidateShouldDescription3",title.getCandidateShouldDescription3());
                intent.putExtra("CandidateShouldDescription4",title.getCandidateShouldDescription4());
                intent.putExtra("CandidateShouldDescription5",title.getCandidateShouldDescription5());
                intent.putExtra("KhaliDabbaHeading",title.getKhaliDabbaHeading());
                intent.putExtra("KhaliDabbaDescription",title.getKhaliDabbaDescription());
                intent.putExtra("ApplyLink",title.getApplyLink());
                intent.putExtra("category",title.getCategory());

                v.getContext().startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        return kuchbhi.size();
    }

    public class postviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView designation;
        TextView company_name;
        TextView location_op;
        NeumorphCardView cardView;

        public postviewholder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.post_1);
            img = itemView.findViewById(R.id.logo);
            designation = itemView.findViewById(R.id.designation);
            company_name = itemView.findViewById(R.id.company_name);
            location_op = itemView.findViewById(R.id.location_op);

        }
    }
}

