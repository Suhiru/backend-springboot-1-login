package com.suhiru.sec.securitytestproject.service;

import com.suhiru.sec.securitytestproject.model.User;
import com.suhiru.sec.securitytestproject.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    //Save Users
    public User saveUser(User user){

       return registrationRepository.save(user);

    }
    //Find Users By Id
    public User findUserByEmailId(String emailId){

        return registrationRepository.findUserByEmailId(emailId);
    }

    //Authenticate
    public User findUserByEmailIdAndPassword(String emailId , String password){

        return registrationRepository.findUserByEmailIdAndPassword(emailId,password);
    }
}
