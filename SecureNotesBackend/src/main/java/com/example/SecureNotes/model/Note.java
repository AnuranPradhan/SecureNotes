package com.example.SecureNotes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

@Lob
    private String content;

    private String ownerUsername;

}
