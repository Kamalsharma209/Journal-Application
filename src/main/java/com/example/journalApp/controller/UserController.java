package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/id/{Userid}")
    public ResponseEntity<User> getEntries(@PathVariable String Userid){
        ObjectId objectId = new ObjectId(Userid);
        Optional<User> user = userService.findById(objectId);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ObjectId id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> UpdateUserById(@RequestBody User newUser , @PathVariable String username){
        User old = userService.findByUserName(username);
        if(old != null){
            old.setUsername(newUser.getUsername() != null && !newUser.getUsername().equals("") ? newUser.getUsername() : old.getUsername());
            old.setPassword(newUser.getPassword() != null && !newUser.getPassword().equals("") ? newUser.getPassword() : old.getPassword());
            userService.saveNewUser(old);
            return new ResponseEntity<>(old , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
