package com.example.demo.HomeController;

import com.example.demo.HServiceIntercace.QuestionsOper;
import com.example.demo.HServiceIntercace.UserOper;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Home {

    @Autowired
    private UserOper userOper;

    @Autowired
    private QuestionsOper questionsOper;

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
    public String QuestionPage(){
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


}
