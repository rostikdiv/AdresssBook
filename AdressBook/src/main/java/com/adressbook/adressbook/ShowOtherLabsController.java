package com.adressbook.adressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowOtherLabsController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnChangePhoto;

    @FXML
    private ImageView picture1;

    @FXML
    private ImageView picture2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    void changePhoto(ActionEvent event) {
        if (picture1.isVisible() && !picture2.isVisible()){
            picture1.setVisible(false);
            picture2.setVisible(true);

            label1.setVisible(false);
            label2.setVisible(true);
        }
        else if (!picture1.isVisible() && picture2.isVisible()){
            picture1.setVisible(true);
            picture2.setVisible(false);

            label1.setVisible(true);
            label2.setVisible(false);
        }
    }

    @FXML
    void initialize() {
        assert btnChangePhoto != null : "fx:id=\"btnChangePhoto\" was not injected: check your FXML file 'showOtherLabs.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'showOtherLabs.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'showOtherLabs.fxml'.";
        assert picture1 != null : "fx:id=\"picture1\" was not injected: check your FXML file 'showOtherLabs.fxml'.";
        assert picture2 != null : "fx:id=\"picture2\" was not injected: check your FXML file 'showOtherLabs.fxml'.";


        Image image1 = new Image(getClass().getResourceAsStream("/com/adressbook/adressbook/castle 1.jpeg"));
        Image image2 = new Image(getClass().getResourceAsStream("/com/adressbook/adressbook/castle 2.jpeg"));

        picture1.setImage(image1);
        picture1.setVisible(true);

        picture2.setImage(image2);
        picture2.setVisible(false);

        label1.setVisible(true);
        label2.setVisible(false);



    }
}
