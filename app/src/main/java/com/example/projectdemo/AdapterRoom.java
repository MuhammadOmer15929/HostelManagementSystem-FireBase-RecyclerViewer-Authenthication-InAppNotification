package com.example.projectdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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
import java.util.HashMap;
import java.util.Map;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.MyViewHolder> {

    Context context;
    ArrayList<UserRoom> userRequestArrayList;




    public AdapterRoom(Context context, ArrayList<UserRoom> userRequestArrayList) {
        this.context = context;
        this.userRequestArrayList = userRequestArrayList;
    }

    @NonNull
    @Override
    public AdapterRoom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item_design_rooms,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRoom.MyViewHolder holder, int position) {

        UserRoom user =userRequestArrayList.get(position);
        holder.FullName.setText(user.FullName);


        String userID;



        holder.status1.setText(user.RoomB);
        holder.status.setText(user.RoomNo);
        holder.RollNo.setText(user.RollNo);



        FirebaseFirestore db;

        holder.firebaseAuth= FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();


        userID= holder.firebaseAuth.getCurrentUser().getUid();
        holder.firebaseAuth=FirebaseAuth.getInstance();


        String url1=null;
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
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> user = new HashMap<>();
                user.put("RoomNo",holder.RoomNo.getText().toString());
                user.put("RoomB",holder.RoomB.getText().toString());
                db.collection("Users").orderBy("RoomNo").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && !task.getResult().isEmpty())
                        {
                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
                            String DocumentID =documentSnapshot.getId();

                            db.collection("Users").document(userRequestArrayList.get(position).getId()).update("RoomNo",holder.RoomNo.getText().toString(),"RoomB",holder.RoomB.getText().toString() ).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Toast.makeText(context, "Allocated", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context, "Not-Allocated", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }
                });
            }
        });

//        holder.btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Map<String, Object> user = new HashMap<>();
//                user.put("isMess", "Un-Paid");
//                db.collection("Users").whereEqualTo("isMess","Paid").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful() && !task.getResult().isEmpty())
//                        {
//                            DocumentSnapshot documentSnapshot =task.getResult().getDocuments().get(0);
//                            String DocumentID =documentSnapshot.getId();
//                            db.collection("Users").document(DocumentID).update("isMess","Un-Paid").addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(context, "updated", Toast.LENGTH_SHORT).show();
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(context, "Not-updated", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        }
//                    }
//                });
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return userRequestArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {



        ImageView url;
        TextView FullName,RollNo;
        Button btn1;
        EditText RoomB;
        ImageView Img3;
        EditText RoomNo;
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;

        TextView status1;
        TextView status;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            Img3=itemView.findViewById(R.id.imgrm);

            btn1=itemView.findViewById(R.id.btn_done);
            RoomB=itemView.findViewById(R.id.occupied);
            RoomNo=itemView.findViewById(R.id.enter_room_no);
            url=itemView.findViewById(R.id.imgrm);
            FullName=itemView.findViewById(R.id.namerm);
            RollNo=itemView.findViewById(R.id.rollnmberrm);
            status=itemView.findViewById(R.id.textView10);
            status1=itemView.findViewById(R.id.textView13);





        }
    }
}
