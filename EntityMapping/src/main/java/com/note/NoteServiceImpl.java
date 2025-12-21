package com.note;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note getNote(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note updateNote(Long id, Note updated) {
        Note existing = getNote(id);
        existing.setMessage(updated.getMessage());
        existing.setDeal(updated.getDeal());
        return repository.save(existing);
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
