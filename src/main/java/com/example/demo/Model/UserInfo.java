package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 20 ,min = 5)
    private String username;

    @NotNull
    private String Password;

    @NotNull(message = "ERROR")
    private String fullName;

    @NotNull(message = "ERROR")
    private String email;

    @NotNull(message = "ERROR")
    private String dateOfBirth ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Questions> userQuestion  =  new ArrayList<Questions>();



}
