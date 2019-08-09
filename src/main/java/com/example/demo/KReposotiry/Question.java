package com.example.demo.KReposotiry;

import com.example.demo.Model.QuestionsAndAnswer;
import com.example.demo.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Question extends JpaRepository<QuestionsAndAnswer,Long> {

    List<QuestionsAndAnswer> findAllByUser(UserInfo user);
}
