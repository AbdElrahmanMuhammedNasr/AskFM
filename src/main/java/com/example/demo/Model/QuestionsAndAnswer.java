package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class QuestionsAndAnswer {

    @Id
    @GeneratedValue
    private  Long id;

    private String question;

    private String answer ;

    @ManyToOne
    @JsonIgnore
    private  UserInfo user;

}
