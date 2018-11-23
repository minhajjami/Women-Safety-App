package com.example.auvik.womensafety;

/**
 * Created by User on 2/3/2017.
 */

public class User {
    private String username;
    private String email;
    private String password;
    private String mobileno;
    private String emmobileno;
    private String message;
    private String birthdate;


    public void setUsername(String username){
        this.username= username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setMobileno(String mobileno){
        this.mobileno= mobileno;
    }
    public String getMobileno(){
        return this.mobileno;
    }
    public void setEmmobileno(String emmobileno){
        this.emmobileno= emmobileno;
    }
    public String getEmmobileno(){
        return this.emmobileno;
    }
    public void setMessage(String message){
        this.message= message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setBirthdate(String birthdate){
        this.birthdate= birthdate;
    }
    public String getBirthdate(){
        return this.birthdate;
    }
}
