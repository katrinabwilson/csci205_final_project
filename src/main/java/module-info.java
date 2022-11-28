module csci205_final_project{
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports TypingGame;
    opens TypingGame to javafx.fxml;
    exports TypingGame2;
    opens TypingGame2 to javafx.fxml;

    exports CodeBash;
    opens CodeBash to javafx.fxml;

    exports CodeBash.model.TimingClass;
    }