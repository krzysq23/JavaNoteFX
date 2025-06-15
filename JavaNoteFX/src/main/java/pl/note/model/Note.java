package pl.note.model;

import java.time.LocalDateTime;

public class Note {

    private int id;
    private String title;
    private String content;
    private LocalDateTime addingDate;
    private LocalDateTime editDate;

    public Note(int id, String title, String content, LocalDateTime addingDate, LocalDateTime editDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.addingDate = addingDate;
        this.editDate = editDate;
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

    public LocalDateTime getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDateTime addingDate) {
        this.addingDate = addingDate;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

}
