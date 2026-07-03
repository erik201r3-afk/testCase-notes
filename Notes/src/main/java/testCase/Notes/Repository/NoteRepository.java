package testCase.Notes.Repository;

import testCase.Notes.Model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteRepository {
    Note save(Note note);
    Optional<Note> findById(int id);
    List<Note> findAll();
    void delete(int id);
}
