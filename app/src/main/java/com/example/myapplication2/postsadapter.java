package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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
        holder.company_name.setText(title.getCompany_name().replaceAll(".png" , ""));
        holder.location_op.setText(title.getLocation());
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));

        if (title.getCategory().equals("Internship")) {
            holder.img.setImageResource(R.drawable.freshers_2);
        }else if (title.getCategory().equals("Job | Full-time ")) {
            holder.img.setImageResource(R.drawable.professional);
        }else{
            holder.img.setImageResource(R.drawable.hacker);
        }


         class KeyValueDB {

            SharedPreferences getPrefs(Context context) {
                return context.getSharedPreferences("pref", Context.MODE_PRIVATE);
            }

           public boolean getState(Context context) {
                return getPrefs(context).getBoolean(title.getCompany_name(),false);
            }

            public void setState(Context context) {
                SharedPreferences.Editor editor = getPrefs(context).edit();
                editor.putBoolean(title.getCompany_name(),true);
                editor.commit();
            }

            public void removeState(Context context) {
                SharedPreferences.Editor editor = getPrefs(context).edit();
                editor.remove(title.getCompany_name());
                editor.commit();
            }


        }

        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,          Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(400);
                rotate.setInterpolator(new LinearInterpolator());
                holder.bookmark.startAnimation(rotate);

                KeyValueDB op = new KeyValueDB();

                if(op.getState(view.getContext())){
                    op.removeState(view.getContext());
                    holder.bookmark.setImageResource(R.drawable.bookmark_false);

                }else{
                    op.setState(view.getContext());
                    holder.bookmark.setImageResource(R.drawable.bookmark_true);
                }
            }
        });

        KeyValueDB op2 = new KeyValueDB();
        Boolean isbookmark = op2.getState(holder.bookmark.getContext());

        if(isbookmark){
            holder.bookmark.setImageResource(R.drawable.bookmark_true);
        }else{
            holder.bookmark.setImageResource(R.drawable.bookmark_false);

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
        ImageButton bookmark;
        TextView designation;
        TextView company_name;
        TextView location_op;
        NeumorphCardView cardView;

        public postviewholder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.post_1);
            img = itemView.findViewById(R.id.logo);
            bookmark = itemView.findViewById(R.id.bookmark);
            designation = itemView.findViewById(R.id.designation);
            company_name = itemView.findViewById(R.id.company_name);
            location_op = itemView.findViewById(R.id.location_op);

        }
    }
}

