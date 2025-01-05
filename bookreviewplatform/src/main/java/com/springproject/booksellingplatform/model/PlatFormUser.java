package com.springproject.booksellingplatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//LamBok for getters, setters and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatFormUser {
    @Id //To define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //To auto generate the id val
    @JsonProperty("UserID")
    private int UserID;

    @JsonProperty("UserName")
    private String UserName;

    @JsonProperty("Role")
    private String Role;

    @JsonProperty("Email")
    private String Email;

    @JsonProperty("Password")
    private String Password;
}
