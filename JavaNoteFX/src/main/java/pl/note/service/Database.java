package pl.note.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.note.model.Note;

import static java.time.LocalDateTime.now;

public class Database {

    private static int increment = 11;

    private static final ObservableList<Note> notes = FXCollections.observableArrayList(
            new Note(1, "Zakupy", "Kupić mleko, chleb, jajka", now(), now()),
            new Note(2, "Praca domowa", "Napisać wypracowanie z polskiego", now(), now()),
            new Note(3, "Pomysł", "Stworzyć aplikację do zarządzania zadaniami", now(), now()),
            new Note(4, "Spotkanie", "Umówione spotkanie z Piotrem w czwartek", now(), now()),
            new Note(5, "Książki", "Przeczytać 'Lalka' i 'Zbrodnia i kara'", now(), now()),
            new Note(6, "Plan dnia", "8:00 - siłownia, 10:00 - praca, 18:00 - film", now(), now()),
            new Note(7, "Lista filmów", "Oglądnąć Interstellar, Incepcję i Tenet", now(), now()),
            new Note(8, "Cytat", "„Cokolwiek potrafisz zrobić, lub marzysz że potrafisz, zacznij to robić.”", now(), now()),
            new Note(9, "Zakładki", "https://news.ycombinator.com, https://openai.com", now(), now()),
            new Note(10, "Notatka testowa", "To jest przykładowa notatka testowa", now(), now())
    );

    public static int getIncrement() {
        return increment++;
    }

    public static ObservableList<Note> getAllNotes() {
        return notes;
    }

    public static Note findById(int id) {
        return notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
    }

    public static void add(Note note) {
        note.setId(getIncrement());
        notes.add(note);
    }

    public static void remove(Note note) {
        notes.remove(note);
    }
}
