package com.springproject.bookreviewplatform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
//LamBok for getters, setters and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id //To define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //To auto generate the id val
    @JsonProperty("ReviewID")
    private int ReviewID;

    @JsonProperty("ISBN")
    private String ISBN;

    @JsonProperty("UserID")
    private String UerID;

    @JsonProperty("ReviewDescription")
    private String ReviewDescription;

    @JsonProperty("ReviewTimestamp")
    private Date ReviewTimestamp;
}
