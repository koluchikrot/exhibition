module Exhibition {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.xml;
    requires javafx.web;

    opens pushkinMuseum;
    opens pushkinMuseum.view;
}