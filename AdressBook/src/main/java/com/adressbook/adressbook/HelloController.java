package com.adressbook.adressbook;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;


public class HelloController {

    Person person=new Person();
    private ColectionAdressBook adressBookImpl =new ColectionAdressBook();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnRed;

    @FXML
    private Button btnSearch;

    @FXML
    private CustomTextField textField;    @FXML
    private Button btnExit;

    @FXML
    private Button btnOtherLabs;
    @FXML
    private Label totalAmount;

    @FXML
    private TableColumn<Person, String > tableColumnPIP;

    @FXML
    private TableColumn<Person, String> tableColumnPhone;
    @FXML
    public TableView<Person> tableAdressBook;

    private EntryTableController controller;
    public ObservableList<Person> backupList = FXCollections.observableArrayList();




    public void addToAdressBook(Person person) {
        adressBookImpl.add(person);
    }

    @FXML
    void openWindow(ActionEvent event) throws IOException, URISyntaxException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("entryTable.fxml"));



        try {
            Stage stage = new Stage();
            Scene scene=new Scene(fxmlLoader.load(),400,100);
            stage.setScene(scene);

            stage.setTitle("вікно редагування");
            stage.setMinHeight(400);
            stage.setMinWidth(100);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnOtherLabs.getScene().getWindow());
            stage.show();

            controller = fxmlLoader.getController();
            controller.setAdressBook(adressBookImpl);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startAction(ActionEvent event) throws IOException, URISyntaxException {
        Button clicedButton = (Button) event.getSource();

        switch (clicedButton.getId()){
            case "btnAdd":
                controller.setPerson(new Person());
                openWindow(event);
                adressBookImpl.add(controller.getPerson());
                break;
            case "btnRed ":
                controller.setPerson(person);
                tableAdressBook.getSelectionModel().getSelectedItem();
                openWindow(event);
                break;
            case "btnDel":
                adressBookImpl.delete(person);
                tableAdressBook.getSelectionModel().getSelectedItem();
                break;

        }
    }
    @FXML
    void addData(ActionEvent event) throws IOException, URISyntaxException {
        openWindow(event);
        controller.setPerson(new Person());
        adressBookImpl.add(controller.getPerson());
    }

    @FXML
    void redakt(ActionEvent event) throws IOException, URISyntaxException {

        Person person1 =tableAdressBook.getSelectionModel().getSelectedItem();
        openWindow(event);
        controller.setPerson(person1);

    }
    @FXML
    void deleting(ActionEvent event) throws IOException, URISyntaxException {
        Person person1= tableAdressBook.getSelectionModel().getSelectedItem();
        adressBookImpl.delete(person1);
    }

    @FXML
    void searching(ActionEvent event) {
        initTable();
        String searchText = textField.getText().trim().toLowerCase();

        // Якщо текстове поле порожнє, повертаємо всі записи
        if (searchText.isEmpty()) {
            adressBookImpl.getPersonList().setAll(backupList);
            return;
        }

        ObservableList<Person> filteredList = FXCollections.observableArrayList();

        // Шукаємо записи, що містять введений текст
        for (Person person : backupList) {
            boolean matches = false;

            // Перевіряємо поля, що можуть бути null
            if (person.getPip() != null && person.getPip().toLowerCase().contains(searchText)) {
                matches = true;
            }
            if (person.getPhone() != null && person.getPhone().toLowerCase().contains(searchText)) {
                matches = true;
            }

            if (matches) {
                filteredList.add(person);
            }
        }

        // Оновлюємо список відфільтрованими записами
        adressBookImpl.getPersonList().setAll(filteredList);
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    void showingOtherLabs(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("showOtherLabs.fxml"));

        try {
            Stage stage = new Stage();
            Scene scene=new Scene(fxmlLoader.load(),600,600);
            stage.setScene(scene);

            stage.setTitle("інша Лаба");
            stage.setMinHeight(600);
            stage.setMinWidth(600);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnOtherLabs.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Exit(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnOtherLabs != null : "fx:id=\"btnOtherLabs\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnRed != null : "fx:id=\"btnRed\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'hello-view.fxml'.";

        setupClearButtonField(textField);

        initTable();
    }

    public void initTable() {
        tableColumnPIP.setCellValueFactory(new PropertyValueFactory<>("pip"));
        tableColumnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                updateCountLabel();
            }
        });
        backupList.clear();
        backupList.addAll(adressBookImpl.getPersonList()); // Копіюємо початкові дані
        tableAdressBook.setItems(adressBookImpl.getPersonList());



    }

    private void updateCountLabel(){
        totalAmount.setText("кількість записів: "+ adressBookImpl.getPersonList().size());
    }
    @FXML
    void new_Alert(ActionEvent event){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Видалення");

        alert.setHeaderText("Results:");
        alert.setContentText("Видалення може призвести до заміни порядку осіб у адресній книзі! ");

        alert.showAndWait();
    }

}
