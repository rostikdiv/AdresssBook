module com.adressbook.adressbook {
    requires javafx.fxml;
    requires org.controlsfx.controls;


    opens com.adressbook.adressbook to javafx.fxml;
    exports com.adressbook.adressbook;
}