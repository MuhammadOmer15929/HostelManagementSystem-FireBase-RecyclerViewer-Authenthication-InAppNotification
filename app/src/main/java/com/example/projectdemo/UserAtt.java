package com.example.projectdemo;

public class UserAtt {

    String FullName;
    String RollNo;
    String url;
    String Id;


    String Mobile;
    String Phone;

    public UserAtt(String fullName, String rollNo, String url, String id, String mobile, String phone, String bloodGroup, String category, String gender, String localGuardian, String class1, String att, String roomB, String roomNo, String isMess, String year, String branch, String CNIC, String fatherName, String email, String permeAdd) {
        FullName = fullName;
        RollNo = rollNo;
        this.url = url;
        Id = id;
        Mobile = mobile;
        Phone = phone;
        BloodGroup = bloodGroup;
        Category = category;
        Gender = gender;
        LocalGuardian = localGuardian;
        Class1 = class1;
        Att = att;
        RoomB = roomB;
        RoomNo = roomNo;
        this.isMess = isMess;
        Year = year;
        Branch = branch;
        this.CNIC = CNIC;
        FatherName = fatherName;
        Email = email;
        PermeAdd = permeAdd;
    }

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

    public UserAtt() {
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPermeAdd() {
        return PermeAdd;
    }

    public void setPermeAdd(String permeAdd) {
        PermeAdd = permeAdd;
    }
}
