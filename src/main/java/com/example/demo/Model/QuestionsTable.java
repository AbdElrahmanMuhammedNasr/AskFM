package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class QuestionsTable {

    @Id
    @GeneratedValue
    private Long Id;

    private  String question;

    @ManyToOne
    @JsonIgnore
    private UserInfo  userInfo;

}
