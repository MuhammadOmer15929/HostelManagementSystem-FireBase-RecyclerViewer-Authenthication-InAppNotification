package com.example.projectdemo;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterMess extends RecyclerView.Adapter<AdapterMess.MyViewHolder> {

    Context context;
    int index;
    ArrayList<UserMess>userRequestArrayList;

    UserMess user;
    FirebaseFirestore db;



    public AdapterMess(Context context, ArrayList<UserMess> userRequestArrayList) {
        this.context = context;
        this.userRequestArrayList = userRequestArrayList;
    }

    @NonNull
    @Override
    public AdapterMess.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.itemdesignmess,parent,false);



        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMess.MyViewHolder holder, int position) {

         user =userRequestArrayList.get(position);
        holder.FullName.setText(user.FullName);
        holder.RollNo.setText(user.RollNo);

        holder.firebaseAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        String url1=null;
        url1=user.getUrl();
        Picasso.get().load(url1).into(holder.url);

        holder.Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.Profile.getContext(),showprofilerecycler.class);

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



                holder.Profile.getContext().startActivity(intent);

            }
        });

        holder.Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful() && !task.getResult().isEmpty())
                        {

                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
                            String DocumentID =documentSnapshot.getId();





                            db.collection("Users").document(userRequestArrayList.get(position).getId()).update("isMess","Paid").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {





                                    Toast.makeText(context, "Bill-Paid", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Bill-Unpaid", Toast.LENGTH_SHORT).show();
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
                db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && !task.getResult().isEmpty())
                        {

                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
                            String DocumentID =documentSnapshot.getId();

                            db.collection("Users").document(userRequestArrayList.get(position).getId()).update("isMess","Un-Paid").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "updated", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Not-updated", Toast.LENGTH_SHORT).show();
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
        ImageView Profile;
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            url=itemView.findViewById(R.id.imgmess);
            FullName=itemView.findViewById(R.id.namemess);

            Profile=itemView.findViewById(R.id.imgmess);
            Img1=itemView.findViewById(R.id.checkmess);
            Img2=itemView.findViewById(R.id.check2mess);
            RollNo=itemView.findViewById(R.id.rollnmbermess);


        }
    }


}
