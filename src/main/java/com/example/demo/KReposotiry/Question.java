package com.example.demo.KReposotiry;

import com.example.demo.Model.Questions;
import com.example.demo.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Question extends JpaRepository<Questions,Long> {

    List<Questions> findAllByUser(UserInfo user);
}
