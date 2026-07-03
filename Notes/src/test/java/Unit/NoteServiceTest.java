package Unit;

import testCase.Notes.Model.Note;
import testCase.Notes.Repository.NoteRepository;
import testCase.Notes.Service.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    NoteRepository repo;

    @InjectMocks
    NoteServiceImpl service;

    @Test
    void createNote() {
        Note note = new Note();
        when(repo.save(any())).thenReturn(note);

        Note result = service.create(note);

        assertNotNull(result);
        verify(repo).save(any());
    }

    @Test
    void getNotFound() {
        when(repo.findById(any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.get(1));
    }

    @Test
    void filterByTag() {
        Note note = new Note();
        note.setTags(Set.of("work"));
        when(repo.findAll()).thenReturn(List.of(note));

        List<Note> result = service.getAll("work");

        assertEquals(1, result.size());
    }
}
