package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {


    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;


    @GetMapping("{userName}")
    public ResponseEntity<?>getAllJournalEntriesOfUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty() ){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry , @PathVariable String userName){
        try{
            journalEntryService.saveEntry(myEntry, userName );
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);

        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntries(@PathVariable String myId) {

        ObjectId objectId = new ObjectId(myId);
        Optional<JournalEntry> journalEntry = journalEntryService.findById(objectId);

        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("id/{userName}/{myid}")
    public ResponseEntity<?>deleteJournalEntriesbyID(@PathVariable ObjectId myid, @PathVariable String userName)
    {
        journalEntryService.deleteById(myid, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{userName}/{myid}")
    public ResponseEntity<?> UpdateJournalEntriesbyId(@PathVariable ObjectId myid , @RequestBody JournalEntry newEntry, @PathVariable String userName){
        JournalEntry old = journalEntryService.findById(myid).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
