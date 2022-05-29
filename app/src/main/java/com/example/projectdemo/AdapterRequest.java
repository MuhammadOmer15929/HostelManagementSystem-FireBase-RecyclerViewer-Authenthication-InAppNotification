package com.example.projectdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterRequest extends RecyclerView.Adapter<AdapterRequest.MyViewHolder> {

    Context context;
    ArrayList<UserRequest>userRequestArrayList;



    public AdapterRequest(Context context, ArrayList<UserRequest> userRequestArrayList) {
        this.context = context;
        this.userRequestArrayList = userRequestArrayList;
    }

    @NonNull
    @Override
    public AdapterRequest.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item_design_student_request,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRequest.MyViewHolder holder, int position) {

        UserRequest user =userRequestArrayList.get(position);
        holder.FullName.setText(user.FullName);
        holder.RollNo.setText(user.RollNo);

        FirebaseFirestore db;
        db=FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        String url1;
        url1=user.getUrl();
        Picasso.get().load(url1).into(holder.url);

        holder.Img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.Img3.getContext(),showprofilerecycler.class);

                intent.putExtra("FullName",userRequestArrayList.get(position).getFullName());
                intent.putExtra("Att",userRequestArrayList.get(position).getAtt());
                intent.putExtra("BloodGroup",userRequestArrayList.get(position).getBloodGroup());
                intent.putExtra("Branch",userRequestArrayList.get(position).getBranch());
                intent.putExtra("CNIC",userRequestArrayList.get(position).getCNIC());
                intent.putExtra("Category",userRequestArrayList.get(position).getCategory());
                intent.putExtra("Class1",userRequestArrayList.get(position).getClass1());
                intent.putExtra("Email",userRequestArrayList.get(position).getEmail());
                intent.putExtra("FatherName",userRequestArrayList.get(position).getFatherName());
                intent.putExtra("Gender",userRequestArrayList.get(position).getGender());
                intent.putExtra("PermeAdd",userRequestArrayList.get(position).getPermeAdd());
                intent.putExtra("Phone",userRequestArrayList.get(position).getPhone());
                intent.putExtra("RollNo",userRequestArrayList.get(position).getRollNo());
                intent.putExtra("RoomB",userRequestArrayList.get(position).getRoomB());
                intent.putExtra("RoomNo",userRequestArrayList.get(position).getRoomNo());
                intent.putExtra("Year",userRequestArrayList.get(position).getYear());
                intent.putExtra("isMess",userRequestArrayList.get(position).getIsMess());
                intent.putExtra("localGuardian",userRequestArrayList.get(position).getLocalGuardian());
                intent.putExtra("url",userRequestArrayList.get(position).getUrl());



                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



                holder.Img3.getContext().startActivity(intent);
            }
        });

        holder.Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && !task.getResult().isEmpty()) {

                            DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                            String DocumentID = documentSnapshot.getId();

                            db.collection("Users").document(userRequestArrayList.get(position).getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "Record Deleted", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Not-Deleted", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return userRequestArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {


        ImageView url;
        TextView FullName,RollNo;
        ImageView Img1;
        ImageView Img2;
        ImageView Img3;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            Img3=itemView.findViewById(R.id.img);
            url=itemView.findViewById(R.id.img);
            FullName=itemView.findViewById(R.id.name);
            Img1=itemView.findViewById(R.id.check);
            RollNo=itemView.findViewById(R.id.rollnmber);


        }
    }

}
