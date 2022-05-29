package com.example.projectdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<UserRoom> userMessArrayListArrayList;
    AdapterRoom adapterRoom;
    FirebaseFirestore db;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Objects.requireNonNull(getSupportActionBar()).hide();


        recyclerView = findViewById(R.id.recycle4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        db = FirebaseFirestore.getInstance();
        userMessArrayListArrayList = new ArrayList<UserRoom>();
        adapterRoom = new AdapterRoom(RoomActivity.this, userMessArrayListArrayList);
        recyclerView.setAdapter(adapterRoom);


        db.collection("Users").orderBy("RollNo").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d : list) {
                    UserRoom obj = d.toObject(UserRoom.class);
                    userMessArrayListArrayList.add(obj);
                }
                adapterRoom.notifyDataSetChanged();
            }


            //getting data from firestore


//        EventChangeListener();

        });
    }
//
//    private void EventChangeListener() {
//
//        db.collection("Users").orderBy("FullName", Query.Direction.ASCENDING)
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                        if(error!=null)
//                        {
//
//
//                            Log.e("Firestore Error",error.getMessage());
//                            return;
//                        }
//                        for (DocumentChange dc : value.getDocumentChanges())
//                        {
//                            if(dc.getType() == DocumentChange.Type.ADDED);
//
//                            {
//
//                                userMessArrayListArrayList.add(dc.getDocument().toObject(UserRoom.class));
//
//
//                                adapterRoom.notifyDataSetChanged();
//
//                            }
//
//
//
//
//                        }
//                    }
//                });
//    }
}