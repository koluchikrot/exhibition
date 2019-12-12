module Exhibition {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires java.xml;
    requires java.prefs;
    requires java.compiler;
//    requires java.xml.bind;

    opens pushkinMuseum;
    opens pushkinMuseum.view;
    opens pushkinMuseum.model;
}