package com.suhiru.sec.securitytestproject.service;

import com.suhiru.sec.securitytestproject.model.User;
import com.suhiru.sec.securitytestproject.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user){

       return registrationRepository.save(user);

    }

    public User findUserByEmailId(String emailId){

        return registrationRepository.findUserByEmailId(emailId);
    }

    public User findUserByEmailIdAndPassword(String emailId , String password){

        return registrationRepository.findUserByEmailIdAndPassword(emailId,password);
    }
}
