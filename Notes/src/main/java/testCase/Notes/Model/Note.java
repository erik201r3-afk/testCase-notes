package testCase.Notes.Model;

import java.time.Instant;
import java.util.Set;

public class Note {
    private int id; //Применен в угоду более удобного тестирования изначально был UUID, гет запросы были не слишком удобны
    private String title;
    private String content;
    private Instant createdAt;
    private Set<String> tags;

    public Note(String title, String content, Set<String> tags) {
        this.title = title;
        this.content = content;
        this.createdAt = Instant.now();
        this.tags = tags;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
