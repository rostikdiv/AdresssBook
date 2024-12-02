module com.adressbook.adressbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.adressbook.adressbook to javafx.fxml;
    exports com.adressbook.adressbook;
}