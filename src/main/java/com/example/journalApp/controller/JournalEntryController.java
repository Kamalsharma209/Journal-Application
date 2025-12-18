package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long , JournalEntry> JournalEntries = new HashMap<>();

    @GetMapping("/getentries")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(JournalEntries.values());
    }
    @PostMapping("/postentries")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        JournalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntries(@PathVariable Long myId){
        return JournalEntries.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntriesbyID(@PathVariable Long myId){
        return JournalEntries.remove(myId);
    }
    @PutMapping("/id/{Id}")
    public JournalEntry UpdateJournalEntriesbyId(@PathVariable Long Id , @RequestBody JournalEntry myEntry){
        return JournalEntries.put(Id, myEntry);
    }
}
