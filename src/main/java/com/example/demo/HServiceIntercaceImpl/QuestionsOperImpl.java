package com.example.demo.HServiceIntercaceImpl;

import com.example.demo.HServiceIntercace.QuestionsOper;
import com.example.demo.KReposotiry.Question;
import com.example.demo.Model.QuestionsAndAnswer;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsOperImpl implements QuestionsOper {

    @Autowired
    private Question questionRepo;

    @Override
    public List<QuestionsAndAnswer> findAllQuestionUser(UserInfo u) {
        return questionRepo.findAllByUser(u);
    }


}
