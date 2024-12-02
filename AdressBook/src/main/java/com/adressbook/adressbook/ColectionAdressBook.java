package com.adressbook.adressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ColectionAdressBook implements AdressBook{
    public ObservableList<Person> personList= FXCollections.observableArrayList();
    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void edit(Person person) {

    }

    @Override
    public boolean delete(Person person) {
        return personList.remove(person);
    }

    public int lenght(){
        return personList.size();
    }



    public void fillTestData(){
        personList.add(new Person("we","4324"));
        personList.add(new Person("we","4324"));
        personList.add(new Person("we","4324"));
        personList.add(new Person("we","4324"));

    }
    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }
    public ObservableList<Person> getPersonList() {
        return personList;
    }
}
