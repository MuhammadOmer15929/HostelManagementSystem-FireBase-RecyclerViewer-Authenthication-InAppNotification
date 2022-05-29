package com.example.projectdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<UserMess> userMessArrayListArrayList;
    FirebaseFirestore db;
    AdapterMess adapterMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);


        Objects.requireNonNull(getSupportActionBar()).hide();
        recyclerView = findViewById(R.id.recycle2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userMessArrayListArrayList = new ArrayList<UserMess>();

        recyclerView.setItemAnimator(null);

        recyclerView.setHasFixedSize(true);

        db = FirebaseFirestore.getInstance();

        adapterMess = new AdapterMess(MessActivity.this, userMessArrayListArrayList);
        recyclerView.setAdapter(adapterMess);


        db.collection("Users").orderBy("RollNo", Query.Direction.ASCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                List<DocumentSnapshot>list=queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list)
                {
                    UserMess obj=d.toObject(UserMess.class);
                    userMessArrayListArrayList.add(obj);
                }
                adapterMess.notifyDataSetChanged();
            }
        });
//        //getting data from firestore
//
//      EventChangeListener();

//    }
//
//    private void EventChangeListener() {
//
//        db.collection("Users").orderBy("FullName", Query.Direction.ASCENDING)
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                        if (error != null) {
//
//
//                            Log.e("Firestore Error", error.getMessage());
//                            return;
//                        }
//
//                        for (DocumentChange dc : value.getDocumentChanges()) {
//
//
//                            if (dc.getType() == DocumentChange.Type.ADDED) ;
//
//                            {
//
//
//
//
//                                userMessArrayListArrayList.add(dc.getDocument().toObject(UserMess.class));
//
//
//
//                            }
//
//                            adapterMess.notifyDataSetChanged();
//
//                        }
//                    }
//                });
//    }
    }


}
