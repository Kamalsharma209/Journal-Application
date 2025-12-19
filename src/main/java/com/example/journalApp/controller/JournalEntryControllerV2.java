package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping("/getentries")
    public List<JournalEntry> getAll(){

        return journalEntryService.getAll();
    }
    @PostMapping("/postentries")
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntries(@PathVariable Long myId){

        return null;
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntriesbyID(@PathVariable Long myId)
    {
        return null;
    }

    @PutMapping("/id/{Id}")
    public JournalEntry UpdateJournalEntriesbyId(@PathVariable Long Id , @RequestBody JournalEntry myEntry){
        return null;
    }
}
