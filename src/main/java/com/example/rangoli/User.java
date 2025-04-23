package com.example.rangoli;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phonenum")
    private String phonenum;
    public User(){}

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getPhonenum(){return phonenum;}
    public void setPhonenum(String phonenum){this.phonenum=phonenum;}
}
