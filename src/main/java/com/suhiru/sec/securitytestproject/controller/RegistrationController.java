package com.suhiru.sec.securitytestproject.controller;


import com.suhiru.sec.securitytestproject.exceptions.CustomizedException;
import com.suhiru.sec.securitytestproject.model.User;
import com.suhiru.sec.securitytestproject.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    //User registration Controller
    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) throws Exception {

        String tempMailId = user.getEmailId();
        if(tempMailId !=null && !"".equals(tempMailId)){
            User userObj = registrationService.findUserByEmailId(tempMailId);
            if(userObj != null){
                throw new CustomizedException("User with "+tempMailId + " already exists");
            }
        }

        User userObj = null;
        userObj=registrationService.saveUser(user);
        return userObj;
    }

    //User login controller
    @PostMapping("/login")
    public User userLogin(@RequestBody User user) throws Exception {

        String tempEmailId = user.getEmailId();
        String password = user.getPassword();
        User userObj = null;
        if(tempEmailId != null && password != null){

            userObj = registrationService.findUserByEmailIdAndPassword(tempEmailId,password);
        }

        if(userObj == null){

            throw new CustomizedException("invalid Credentials");


        }

        return userObj;

    }
}
