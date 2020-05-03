package com.opeyemi.javafx.combobox.controller;

import com.opeyemi.javafx.combobox.data.DataManager;
import com.opeyemi.javafx.combobox.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ComboboxController implements Initializable {

    @FXML
    private ComboBox<Product> productComboBox;


    public void initialize(URL location, ResourceBundle resources) {
        loadComboBoxContent();
    }

    private void loadComboBoxContent() {
        DataManager dataManager = new DataManager();
        ObservableList<Product> productList = FXCollections.observableList(dataManager.comboboxData());
        productComboBox.itemsProperty().setValue(productList);

        productComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Product Name: " + newValue.getName());
            System.out.println("Product Description: " + newValue.getDescription());
            System.out.println("Product Id: " + newValue.getId());
        });

        convertComboDisplayList();

    }

    private void convertComboDisplayList() {
        productComboBox.setConverter(new StringConverter<Product>() {
            @Override
            public String toString(Product product) {
                return product.getName();
            }

            @Override
            public Product fromString(final String string) {
                return productComboBox.getItems().stream().filter(product -> product.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }

}
