package com.note;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return service.createNote(note);
    }

    @GetMapping("/{id}")
    public Note get(@PathVariable Long id) {
        return service.getNote(id);
    }

    @GetMapping
    public List<Note> getAll() {
        return service.getAllNotes();
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteNote(id);
        return "Note deleted successfully!";
    }
}
