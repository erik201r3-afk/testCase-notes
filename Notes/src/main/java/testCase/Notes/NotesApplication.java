package testCase.Notes;

import testCase.Notes.Model.Note;
import testCase.Notes.Service.NoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@Bean
	public CommandLineRunner initNotes(NoteService noteService) {
		return args -> {

			Set<String> tags = new HashSet<>(); // тестовые теги
			tags.add("work");

			// тестовые заметки
			noteService.create(new Note("Java", "Improve skills", tags));
			noteService.create(new Note("Work", "Finish test", tags));
			noteService.create(new Note("Sport", "Running tour", tags));
		};

	}
}
