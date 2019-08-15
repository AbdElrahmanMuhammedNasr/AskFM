package com.example.demo.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Friends {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private  String  email;

    @ManyToOne
    private UserInfo userInfo;
}
