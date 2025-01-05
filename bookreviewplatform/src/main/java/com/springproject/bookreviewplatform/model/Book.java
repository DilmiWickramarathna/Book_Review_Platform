package com.springproject.bookreviewplatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//LamBok for getters, setters and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id //To define primary key
    @JsonProperty("ISBN")
    private String ISBN;

    @JsonProperty("BookName")
    private String BookName;

    @JsonProperty("Author")
    private String Author;

    @JsonProperty("Category")
    private String Category;

    @JsonProperty("Description")
    private String Description;

    @JsonProperty("Rating")
    private int Rating;

}

