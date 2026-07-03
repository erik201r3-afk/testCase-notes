package testCase.Notes.Service;

import testCase.Notes.Model.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    Note create(Note note);
    Note get(int id);
    List<Note> getAll(String tag);
    Note update(int id, Note note);
    void delete(int id);
}