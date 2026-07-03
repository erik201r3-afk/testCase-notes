package testCase.Notes.Repository;

import testCase.Notes.Model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryNoteRepository implements NoteRepository {
    private final Map<Integer, Note> storage = new ConcurrentHashMap<>();

    public Note save(Note note) {
        storage.put(note.getId(), note);
        return note;
    }

    public Optional<Note> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Note> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(int id) {
        storage.remove(id);
    }
}
