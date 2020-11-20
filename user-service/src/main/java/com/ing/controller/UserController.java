package com.ing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.entities.User;
import com.ing.service.UserService;

@RestController
@Validated

public class UserController {

    @Autowired
    UserService userService;


     
    @GetMapping(value="/fetchuser/{id}", produces="application/json")
    @ResponseBody
    
    public ResponseEntity<Object> getUserById(@Valid @PathVariable("id") int id) throws Exception{
    	User user = userService.findByUserid(id);
    	
        return ResponseEntity.ok().body(user.toString());
    }
    
    @PutMapping("/updateuser/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@Valid @PathVariable("id") int id,@RequestBody(required=true) User toUser){
    	
    	User user = userService.updateUser(id,toUser);
    	
    	 return ResponseEntity.ok().body(user.toString());
    	
    }
    
    
   
   
}