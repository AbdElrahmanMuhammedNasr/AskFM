package com.example.demo.HServiceIntercaceImpl;

import com.example.demo.HServiceIntercace.QuestionsOnlyOper;
import com.example.demo.KReposotiry.QuestionsOnly;
import com.example.demo.Model.QuestionsTable;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsOnlyOperImpl implements QuestionsOnlyOper {
    @Autowired
    private QuestionsOnly questionsOnly;
    @Override
    public List<QuestionsTable> findAllQuestions(UserInfo u) {
        return questionsOnly.findAllByUserInfo(u);
    }

    @Override
    public void deleteOneQuestion(Long id) {
        questionsOnly.deleteById(id);
    }

    @Override
    public QuestionsTable findOneQuestion(Long id) {
        return questionsOnly.findById(id).get();
    }

    @Override
    public QuestionsTable findOneQuestionByQuestion(String quest) {
        return questionsOnly.findByQuestion(quest);
    }
}
