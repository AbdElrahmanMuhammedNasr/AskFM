package com.example.demo.HServiceIntercace;


import com.example.demo.Model.QuestionsTable;
import com.example.demo.Model.UserInfo;

import java.util.List;

public interface QuestionsOnlyOper  {

        List<QuestionsTable> findAllQuestions(UserInfo u);

        void  deleteOneQuestion(Long id);
}
