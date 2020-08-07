module NASAProject {
        requires javafx.fxml;
        requires javafx.controls;
        requires javafx.graphics;
        requires java.net.http;
        requires com.google.gson;

        opens com.github.oldschool908.Project.models;
        opens com.github.oldschool908.Project.controllers;
        exports com.github.oldschool908.Project;
        exports com.github.oldschool908.Project.models;
        opens com.github.oldschool908.Project to javafx.graphics;
}