package com.suhiru.sec.securitytestproject.repository;


import com.suhiru.sec.securitytestproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

    public User findUserByEmailId(String emailId);

    public User findUserByEmailIdAndPassword(String emailId,String password);

}
