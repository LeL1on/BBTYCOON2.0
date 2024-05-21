module tycoon {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens tycoon to javafx.fxml;
    exports tycoon;
}
