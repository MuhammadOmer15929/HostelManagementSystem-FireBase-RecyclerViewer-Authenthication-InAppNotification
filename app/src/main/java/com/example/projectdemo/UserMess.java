package com.example.projectdemo;

import java.io.Serializable;

public class UserMess  {
    String FullName;
    String RollNo;
    String url;
    String Id;



    String Mobile;
    String Phone;
    String BloodGroup;
    String Category;
    String Gender;
    String LocalGuardian;
    String Class1;
    String Att;
    String RoomB;
    String RoomNo;
    String isMess;
    String Year;
    String Branch;
    String CNIC;
    String FatherName;
    String Email;
    String PermeAdd;

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public UserMess() {
    }

    public String getAtt() {
        return Att;
    }

    public void setAtt(String att) {
        Att = att;
    }

    public String getRoomB() {
        return RoomB;
    }

    public void setRoomB(String roomB) {
        RoomB = roomB;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getIsMess() {
        return isMess;
    }

    public void setIsMess(String isMess) {
        this.isMess = isMess;
    }

    public UserMess(String ismess, String roomNo, String Roomb , String att, String phone, String fatherName, String email, String mobile, String bloodGroup, String category, String gender, String localGuardian, String class1, String year, String branch, String cnic, String permAdd, String fullName, String rollNo, String url, String id) {
        FullName = fullName;
        Att=att;
        isMess=ismess;
        RoomB=Roomb;
        RoomNo=roomNo;
        Phone=phone;
        FatherName=fatherName;
        RollNo = rollNo;
        Id=id;
        Mobile=mobile;
        BloodGroup=bloodGroup;
        Category=category;
        Gender=gender;
        LocalGuardian=localGuardian;
        Class1=class1;
        Year=year;
        Branch=branch;
        CNIC=cnic;
        Email=email;
        PermeAdd=permAdd;
        this.url = url;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocalGuardian() {
        return LocalGuardian;
    }

    public void setLocalGuardian(String localGuardian) {
        LocalGuardian = localGuardian;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        Class1 = class1;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }


    public String getPermeAdd() {
        return PermeAdd;
    }

    public void setPermeAdd(String permeAdd) {
        PermeAdd = permeAdd;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
