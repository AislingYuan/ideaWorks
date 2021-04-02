package com.cssl.controller;

import com.cssl.pojo.VoteUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/User-login.action")
    String login(VoteUser user, HttpSession session, Model model){
        List<VoteUser> users = us.allUsers();
        String user_name = user.getUserName();
        String password = user.getuPassword();
        for (VoteUser uu : users) {
            if(user_name.equals(uu.getUserName()) && password.equals(uu.getuPassword())){
                session.setAttribute("user",uu);
                model.addAttribute("pageIndex",1);
                return "forward:/load.action";
            }
        }
        return "login.html";
    }

    @RequestMapping("/User-register.action")
    String register(VoteUser user){
        user.setuStatus(2);
        int i = us.addUser(user);
        if(i>0){
            return "login.html";
        }
        return "regist.html";
    }

    @RequestMapping("/IsExist.action")
    @ResponseBody
    Integer isExist(String userName){
        Integer num = us.isExist(userName);
        return num;
    }

    @RequestMapping("/User-exit.action")
    String exit(HttpSession session){
        session.removeAttribute("user");
        return "login.html";
    }

}
