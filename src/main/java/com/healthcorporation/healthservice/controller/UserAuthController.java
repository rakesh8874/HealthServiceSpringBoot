package com.healthcorporation.healthservice.controller;
import com.healthcorporation.healthservice.domain.AuthUser;
import com.healthcorporation.healthservice.security.GenerateJWTToken;
import com.healthcorporation.healthservice.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth-service")
public class UserAuthController {
    private IAuthUserService userService;

    private GenerateJWTToken generateJWTToken;

    @Autowired
    public UserAuthController(IAuthUserService userService, GenerateJWTToken generateJWTToken) {
        this.userService = userService;
        this.generateJWTToken = generateJWTToken;
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody AuthUser user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

   @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthUser authUser){
        AuthUser isUserExist = userService.login(authUser.getUserName(), authUser.getPassword());
        if(isUserExist != null){
            Map<String, String> map = generateJWTToken.generateJWTToken(isUserExist);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        throw new RuntimeException("Invalid Credentials");
   }

   @GetMapping("/getUser/{userName}")
    public ResponseEntity<?> findUserByUsername(@PathVariable String userName){
        return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
   }

}
