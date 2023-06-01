package com.healthcorporation.healthservice.repository;

import com.healthcorporation.healthservice.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Integer> {

    AuthUser findByUserName(String userName);

    AuthUser findByEmail(String email);

    AuthUser findByContactNo(long contactNo);

    AuthUser findByDob(Date date);
}
