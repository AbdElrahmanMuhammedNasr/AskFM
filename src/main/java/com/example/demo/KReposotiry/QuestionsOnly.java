package com.example.demo.KReposotiry;

import com.example.demo.Model.QuestionsTable;
import com.example.demo.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsOnly extends JpaRepository<QuestionsTable ,Long> {

    List<QuestionsTable> findAllByUserInfo(UserInfo u);

    QuestionsTable findByQuestion(String name);
}
