package com.example.projectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class showprofilerecycler extends AppCompatActivity {
    ImageView Img1;
    TextView Name;
    TextView Email;
    TextView Mobile;
    TextView BloodGroup;
    TextView Category;
    TextView Gender;
    TextView RollNo;
    TextView CNIC;
    TextView PermAdd;
    TextView LocalGuardian;
    TextView Class1;
    TextView Year;
    TextView StdPrflExit;
    TextView Branch;
    TextView Att;
    TextView Mess;
    TextView RoomType;
    TextView RoomNO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofilerecycler);
        getSupportActionBar().hide();
        RoomType=findViewById(R.id.textView14Prf);
        RoomNO=findViewById(R.id.textView8Prf);
        Name=findViewById(R.id.tv_usernamePrf);
        Mess=findViewById(R.id.textView5Prf);
        Email=findViewById(R.id.tv_emailaddressPrf);
        Att=findViewById(R.id.textView7Prf);
        Mobile=findViewById(R.id.tv_mobile_umberPrf);
        BloodGroup=findViewById(R.id.tv_blood_groupPrf);
        Category=findViewById(R.id.tv_castPrf);
        Gender=findViewById(R.id.tv_genderPrf);
        RollNo=findViewById(R.id.tv_enrollment_noPrf);
        CNIC=findViewById(R.id.tv_aadhar_noPrf);
        PermAdd=findViewById(R.id.tv_perma_addressPrf);
        LocalGuardian=findViewById(R.id.tv_guardian_namePrf);
        Class1=findViewById(R.id.sp_classPrf);
        Year=findViewById(R.id.sp_yearPrf);
        Img1=findViewById(R.id.iv_display_imagePrf);
        Branch=findViewById(R.id.sp_branchPrf);


        Name.setText(getIntent().getStringExtra("FullName").toString());
        RoomNO.setText(getIntent().getStringExtra("RoomNo").toString());
        RoomType.setText(getIntent().getStringExtra("RoomB").toString());
        Mess.setText(getIntent().getStringExtra("isMess").toString());
        Att.setText(getIntent().getStringExtra("Att").toString());
        Mobile.setText(getIntent().getStringExtra("Phone").toString());
        BloodGroup.setText(getIntent().getStringExtra("BloodGroup").toString());
        Category.setText(getIntent().getStringExtra("Category").toString());
        Gender.setText(getIntent().getStringExtra("Gender").toString());
        RollNo.setText(getIntent().getStringExtra("RollNo").toString());
        CNIC.setText(getIntent().getStringExtra("CNIC").toString());
        PermAdd.setText(getIntent().getStringExtra("PermeAdd").toString());
        LocalGuardian.setText(getIntent().getStringExtra("localGuardian").toString());
        Class1.setText(getIntent().getStringExtra("Class1").toString());
        Year.setText(getIntent().getStringExtra("Year").toString());
        Branch.setText(getIntent().getStringExtra("Branch").toString());

String url=getIntent().getStringExtra("url");

        Picasso.get().load(url).into(Img1);
        Email.setText(getIntent().getStringExtra("Email").toString());

    }
}