package com.example.SecureNotes.Service;


import com.example.SecureNotes.Repository.NoteRepository;
import com.example.SecureNotes.model.Note;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(String name,String content) {
        Note note = new Note();
        note.setOwnerUsername(name);
        note.setContent(content);
        noteRepository.save(note);
        return note;
    }

   public List<Note> findNoteByUserName(String name) {
        return noteRepository.findByOwnerUsername(name);
   }

   public void deleteNoteById(Long id,String name) {
        noteRepository.deleteById(id);
   }

   public void updateNote(String content,String name,long id){
     Note note=   noteRepository.findById(id).orElseThrow(()->new RuntimeException("Note not found"));
        note.setContent(content);
        noteRepository.save(note);
   }
}
