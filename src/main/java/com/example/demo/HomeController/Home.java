package com.example.demo.HomeController;

import com.example.demo.HServiceIntercace.QuestionsOnlyOper;
import com.example.demo.HServiceIntercace.QuestionsOper;
import com.example.demo.HServiceIntercace.UserOper;
import com.example.demo.Model.QuestionsAndAnswer;
import com.example.demo.Model.QuestionsTable;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class Home {

    @Autowired
    private UserOper userOper;

    @Autowired
    private QuestionsOper questionsOper;

    @Autowired
    private QuestionsOnlyOper questionsOnlyOper;

    @RequestMapping(value = {"/"})
    public String homePage(Model model){
        model.addAttribute("UserInfo", new UserInfo());
        return "Home";
    }
    @PostMapping(value = {"/signUp"})
    public  String signUpInsertData(@Valid UserInfo us, Model model , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("UserInfo",new UserInfo());
            System.out.println("Error");
            return "Home";
        }
        userOper.SaveUserInfo(us);
        return "index";
    }


    /*********************************************************************************************/
    @RequestMapping(value = {"/question"})
    public String QuestionPage(Model model){
        UserInfo u  = userOper.findOneUser(new Long(1));
        model.addAttribute("questSDetail" , questionsOnlyOper.findAllQuestions(u));
        return "question";
    }

    /*********************************************************************************************/
    //  i will do for all user ( i have one user so  it  will not  boe much wrong ) and i will fix  it
    @GetMapping(value = {"/profile"})
    public String ProfilePage( Model model){
        UserInfo u  = userOper.findOneUser(new Long(1));
        model.addAttribute("UserDetail" , u);
        model.addAttribute("questDetail" , questionsOper.findAllQuestionUser(u));
        return "profile";
    }

    /*********************************************************************************************/
    @RequestMapping(value = {"/friends"})
    public String FriendsPage(){
        return "friends";
    }

    /*********************************************************************************************/
    @RequestMapping(value = {"/notification"})
    public String NotificationPage(){
        return "notification";
    }

    /*************************************************************************************************/
    @RequestMapping(value = {"/answerpeople/{id}"})
    public String answerPeople(@PathVariable("id") Long id,Model model){
            model.addAttribute("oneQuest",questionsOnlyOper.findOneQuestion(id));
        return "answerpeople";
    }

    @RequestMapping(value = {"/answerQuestion/{id}"})
    public String answerQuest(/*@RequestParam(value = "answer") String answ , @RequestParam("question") String quest , */@PathVariable("id") Long id , HttpServletRequest request){


        QuestionsTable u  = questionsOnlyOper.findOneQuestionByQuestion(request.getParameter("question"));
        //System.out.println("the Data=============>"+u.getUserInfo());

        QuestionsAndAnswer q = new QuestionsAndAnswer();
        q.setQuestion(request.getParameter("question"));
        q.setAnswer( request.getParameter("answer"));
      //  q.setUser(u.getUserInfo());
        questionsOper.saveOneAnswer(q);


        questionsOnlyOper.deleteOneQuestion(id);


        return "redirect:/profile";
    }


    @RequestMapping(value = {"/answerpeople/Delete/{id}"})
    public String answerPeopleDelete(@PathVariable("id") Long id){
        questionsOnlyOper.deleteOneQuestion(id);
        return "answerpeople";
    }

}
