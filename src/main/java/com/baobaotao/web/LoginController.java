package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Yolanda on 05/10/2017.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand ){
        boolean isValidUser =
                userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","usernmae or password wrong");
        }
        else{
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIP((request.getRemoteAddr()));
            user.setLastVisit(new Date());
            userService.loginSuceess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}
