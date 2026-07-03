package testCase.Notes.Service;

import testCase.Notes.Model.Note;
import testCase.Notes.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repo;

    public NoteServiceImpl(NoteRepository repo) {
        this.repo = repo;
    }

    int i = 0;

    public Note create(Note note) {
        note.setId(i++);
        note.setCreatedAt(Instant.now());
        return repo.save(note);
    }

    public Note get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Note> getAll(String tag) {
        return repo.findAll().stream()
                .filter(n -> tag == null || n.getTags().contains(tag))
                .toList();
    }

    public Note update(int id, Note note) {
        Note existing = get(id);
        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
        existing.setTags(note.getTags());
        return repo.save(existing);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
