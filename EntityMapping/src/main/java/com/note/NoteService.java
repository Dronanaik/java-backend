package com.note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);

    Note getNote(Long id);

    List<Note> getAllNotes();

    Note updateNote(Long id, Note updated);

    void deleteNote(Long id);
}
