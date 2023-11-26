package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class NoteEntity {
    @Id
    @GeneratedValue
    private Long noteId;

    @ManyToOne
    private BoardEntity boardEntity;
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getNoteId() {
        return noteId;
    }
}
