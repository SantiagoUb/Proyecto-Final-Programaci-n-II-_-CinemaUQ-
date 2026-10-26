module co.edu.uniquindio.poo.cinemauqproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.cinemauqproject to javafx.fxml;
    exports co.edu.uniquindio.poo.cinemauqproject;
}