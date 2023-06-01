package com.healthcorporation.healthservice.service;

import com.healthcorporation.healthservice.domain.AuthUser;

import java.util.Date;
import java.util.List;

public interface IAuthUserService {

    AuthUser addUser(AuthUser user);

    AuthUser login(String userName, String password);

    List<AuthUser> getAllUsers();

    AuthUser getUserByUserName(String userName);

    AuthUser getUserByContactNo(long contactNo);

    AuthUser getUserByEmail(String email);

    AuthUser getUserByDOB(Date date);

    boolean deleteUser(int id);

    AuthUser updateUser(String userName);

}
