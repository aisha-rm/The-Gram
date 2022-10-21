package com.tmt.thegram;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    @NotBlank(message="First name cannot be blank")
    @Size(min=2, message="First name is too short")
    private String firstName;

    @NotBlank(message="Last name cannot be blank")
    @Size(min=2, message="Last name is too short")
    private String lastName;
    
    @NotBlank(message="Username cannot be blank")
    @Size(min=7, message="Username is too short")
    private String userName;
    
    @Email(message="Invalid email address")
    private String email;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past(message="Date must not be in future")
    private Date dateOfBirth;
    
    private String id;


    public User(){
        this.id = UUID.randomUUID().toString();  
    }

    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
}
