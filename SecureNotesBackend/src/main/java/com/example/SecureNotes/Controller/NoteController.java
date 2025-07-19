package com.example.SecureNotes.Controller;


import com.example.SecureNotes.Service.NoteService;
import com.example.SecureNotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
@PostMapping
    public Note createNote(@RequestBody String content,@AuthenticationPrincipal UserDetails userDetails) {
        String username=userDetails.getUsername();
        return noteService.createNote(username,content);
    }
    @GetMapping
    public List<Note> findAllNotes(@AuthenticationPrincipal UserDetails userDetails) {
    String username=userDetails.getUsername();
    return noteService.findNoteByUserName(username);
    }

@DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails) {
    String username=userDetails.getUsername();
    noteService.deleteNoteById(id,username);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable long id,@RequestBody String content,@AuthenticationPrincipal UserDetails userDetails) {
    String username=userDetails.getUsername();
noteService.updateNote(content,username,id);
    }
}
