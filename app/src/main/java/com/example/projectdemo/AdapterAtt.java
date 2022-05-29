package com.example.projectdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
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
import java.util.HashMap;
import java.util.Map;

public class AdapterAtt extends RecyclerView.Adapter<AdapterAtt.MyViewHolder> {

    Context context;
    ArrayList<UserAtt> userRequestArrayList;




    public AdapterAtt(Context context, ArrayList<UserAtt> userRequestArrayList) {
        this.context = context;
        this.userRequestArrayList = userRequestArrayList;
    }

    @NonNull
    @Override
    public AdapterAtt.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.itemdesignattendence,parent,false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAtt.MyViewHolder holder, int position) {

        UserAtt user =userRequestArrayList.get(position);
        holder.FullName.setText(user.FullName);


        String userID;



        holder.RollNo.setText(user.RollNo);


        holder.setIsRecyclable(false);

        FirebaseFirestore db;

        holder.firebaseAuth= FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();


        userID= holder.firebaseAuth.getCurrentUser().getUid();
        holder.firebaseAuth=FirebaseAuth.getInstance();


        String url1=null;
        url1 =user.getUrl();
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

                Map<String, Object> user = new HashMap<>();
                user.put("Att", "Present");
                db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && !task.getResult().isEmpty())
                        {
                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
                            String DocumentID =documentSnapshot.getId();
                            db.collection("Users").document(userRequestArrayList.get(position).getId()).update("Att","Present").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "Marked Present", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
            }
        });

        holder.Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> user = new HashMap<>();
                user.put("Att", "Absent");
                db.collection("Users").whereEqualTo("Att","Present").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && !task.getResult().isEmpty())
                        {
                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
                            String DocumentID =documentSnapshot.getId();
                            db.collection("Users").document(userRequestArrayList.get(position).getId()).update("Att","Absent").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "Marked-Absent", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
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
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            url=itemView.findViewById(R.id.imgatt);
            FullName=itemView.findViewById(R.id.nameatt);


            Img3=itemView.findViewById(R.id.imgatt);
            Img1=itemView.findViewById(R.id.checkatt);
            Img2=itemView.findViewById(R.id.check2att);
            RollNo=itemView.findViewById(R.id.rollnmberatt);


        }
    }
}
