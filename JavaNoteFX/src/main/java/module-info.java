module pl.note.javanotefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens pl.note.views to javafx.fxml;
    exports pl.note.controller;
    opens pl.note.controller to javafx.fxml;
    exports pl.note;
    opens pl.note to javafx.fxml;
}