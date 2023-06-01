package com.healthcorporation.healthservice.service;

import com.healthcorporation.healthservice.domain.AuthUser;
import com.healthcorporation.healthservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthUserServiceImpl implements IAuthUserService{


    private UserRepository userRepository;

    @Autowired
    public AuthUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public AuthUser addUser(AuthUser user){
       AuthUser authUser = userRepository.findByUserName(user.getUserName());
       if(authUser == null){
           return userRepository.save(user);
       }
       throw new RuntimeException("User Already Exist Of Given User Name");
    }

    @Override
    public AuthUser login(String userName, String password) {
        AuthUser authUser = userRepository.findByUserName(userName);
        if(authUser != null){
            if(authUser.getUserName().equals(userName) && authUser.getPassword().equals(password)){
                return authUser;
            }else{
                return  null;
            }
        }
        throw new RuntimeException("Failed To Login Invalid Credentials");
    }

    @Override
    public List<AuthUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AuthUser getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public AuthUser getUserByContactNo(long contactNo) {
        return userRepository.findByContactNo(contactNo);
    }

    @Override
    public AuthUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public AuthUser getUserByDOB(Date date) {
        return userRepository.findByDob(date);
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public AuthUser updateUser(String userName) {
        return null;
    }
}
