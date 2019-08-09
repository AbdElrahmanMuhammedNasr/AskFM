package com.example.demo.AInitData;

import com.example.demo.KReposotiry.Question;
import com.example.demo.KReposotiry.UserData;
import com.example.demo.Model.Questions;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class inData implements CommandLineRunner {

    @Autowired
    private UserData userDataRepo;

    @Autowired
    private Question questionRepo;

    @Override
    public void run(String... args) throws Exception {
        try{
            UserInfo   u  = new UserInfo();
            u.setUsername("Abddo");
            u.setPassword("abo");
            u.setFullName("AbdElrahman");
            u.setEmail("www.aboo@yahoo.com");
            u.setDateOfBirth("8/8/1998");


            Questions q1 = new Questions();
            q1.setQuestion("who are you");
            q1.setAnswer("i am Abdo");
             q1.setUser(u);

            Questions q2 = new Questions();
            q2.setQuestion("how old are you");
            q2.setAnswer("i am 20");
            q2.setUser(u);

            Questions q3 = new Questions();
            q3.setQuestion("where are you from");
            q3.setAnswer("i am from tanta");
            q3.setUser(u);

            userDataRepo.save(u);
            questionRepo.save(q1);
            questionRepo.save(q2);
            questionRepo.save(q3);



        }
        catch (Exception c){
            c.printStackTrace();
        }

    }
}
