package com.example.demo.HServiceIntercace;

import com.example.demo.Model.QuestionsAndAnswer;
import com.example.demo.Model.UserInfo;

import java.util.List;

public interface QuestionsOper {

    List <QuestionsAndAnswer> findAllQuestionUser(UserInfo  u);
}
