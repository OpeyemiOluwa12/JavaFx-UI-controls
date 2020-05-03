package com.opeyemi.javafx.combobox.data;

import com.opeyemi.javafx.combobox.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public List<Product> comboboxData() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Tailors chalk", "Used for placing marks on cloths for cutting"));
        productList.add(new Product(2, "Tape rule", "Measurement rule for tailors"));
        productList.add(new Product(3, "Hip curve ruler", "For easy cutting of the hip shape on patterns"));
        productList.add(new Product(4, "Pattern paper", "To cut design before transferring to fabrics"));
        productList.add(new Product(5, "Fabric glue", "For gluing fabric patch on another"));
        return productList;
    }
}
