package com.example.demo.HomeController;

import com.example.demo.HServiceIntercace.FriendsOper;
import com.example.demo.HServiceIntercace.QuestionsOnlyOper;
import com.example.demo.HServiceIntercace.QuestionsOper;
import com.example.demo.HServiceIntercace.UserOper;
import com.example.demo.Model.QuestionsAndAnswer;
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

    @Autowired
    private FriendsOper friendsOper;

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
        model.addAttribute("numberOfAnswer" , questionsOper.numberOfAnswer());

        model.addAttribute("questDetail" , questionsOper.findAllQuestionUser(u));
        return "profile";
    }

    /*********************************************************************************************/
    @RequestMapping(value = {"/friends"})
    public String FriendsPage(Model model){
        model.addAttribute("fri",friendsOper.findAllFriends());

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
            model.addAttribute("formAnswer",new QuestionsAndAnswer());

        return "answerpeople";
    }

    @RequestMapping(value = {"/answerQuestion/{id}/{quest}"})
    public String answerQuest(HttpServletRequest request, @PathVariable("id") Long id , @PathVariable("quest") String quest , @ModelAttribute("answer") String answer ){




        String ans = "" ;
        ans = request.getParameter("answer");

        System.out.println("the Data=============>"+quest);
        System.out.println("the Data=============>"+ans);




        /******************* add To another table ********************/

        QuestionsAndAnswer q = new QuestionsAndAnswer();
        q.setQuestion(quest);
       // q.setAnswer( request.getParameter("answer"));
        questionsOper.saveOneAnswer(q);

        /**********************delete from questionTabe *************************/
        questionsOnlyOper.deleteOneQuestion(id);
        /******************************************************************/


        return "redirect:/profile";
    }


    @RequestMapping(value = {"/answerpeople/Delete/{id}"})
    public String answerPeopleDelete(@PathVariable("id") Long id){
        questionsOnlyOper.deleteOneQuestion(id);
        return "answerpeople";
    }

}
