package com.example.demo.HServiceIntercace;

import com.example.demo.Model.Questions;
import com.example.demo.Model.UserInfo;

import java.util.List;

public interface QuestionsOper {

    List <Questions> findAllQuestionUser(UserInfo  u);
}
