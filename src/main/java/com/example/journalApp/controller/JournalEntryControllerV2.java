package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntries(@PathVariable ObjectId myId){

        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntriesbyID(@PathVariable ObjectId id)
    {
        journalEntryService.deleteById(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry UpdateJournalEntriesbyId(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}
