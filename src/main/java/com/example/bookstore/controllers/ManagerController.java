package com.example.bookstore.controllers;

import com.example.bookstore.Main;
import com.example.bookstore.model.ItemsList;
import com.example.bookstore.services.AddItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

abstract public class ManagerController extends UserController {
    @FXML
    protected Button edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9;

    @FXML
    protected Button delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9;

    @FXML
    protected Button viewNewOrders;

    @FXML
    protected Button addItem;


    public ManagerController() {

    }

    @Override
    public void initialize() {
        imageViewArrayList = new ArrayList<>() {{
            add(image1);
            add(image2);
            add(image3);
            add(image4);
            add(image5);
            add(image6);
            add(image7);
            add(image8);
            add(image9);
        }};
        button1ArrayList = new ArrayList<>() {{
            add(delete1);
            add(delete2);
            add(delete3);
            add(delete4);
            add(delete5);
            add(delete6);
            add(delete7);
            add(delete8);
            add(delete9);
        }};
        button2ArrayList = new ArrayList<>() {{
            add(null);
            add(null);
            add(null);
            add(null);
            add(null);
            add(null);
            add(null);
            add(null);
            add(null);
        }};

        priceArrayList = new ArrayList<>() {{
            add(price1Label);
            add(price2Label);
            add(price3Label);
            add(price4Label);
            add(price5Label);
            add(price6Label);
            add(price7Label);
            add(price8Label);
            add(price9Label);
        }};

        titleArrayList = new ArrayList<>() {{
            add(title1Label);
            add(title2Label);
            add(title3Label);
            add(title4Label);
            add(title5Label);
            add(title6Label);
            add(title7Label);
            add(title8Label);
            add(title9Label);
        }};

        descriptionArrayList = new ArrayList<>() {{
            add(description1Text);
            add(description2Text);
            add(description3Text);
            add(description4Text);
            add(description5Text);
            add(description6Text);
            add(description7Text);
            add(description8Text);
            add(description9Text);
        }};

        loadImages();
    }

    protected abstract void refreshScene() throws IOException;

    public void goToHomePage() throws IOException {
        Main m = new Main();
        m.changeScene("home-page-manager.fxml");
    }

    public void goToNewOrdersPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("new-orders-page.fxml");
    }

    public void goToAddItemPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("add-item-page.fxml");
    }

    protected void deleteItem(int index) throws IOException {
        ItemsList.getItems().remove(items.get(index));
        items.remove(index);
        itemsNb = 0;
        ItemsList.decreaseCategoryNo(getCategoryName());
        refreshScene();
        loadImages();
        AddItem.persistItems();
    }

    public void deleteItem1() throws IOException {
        ItemsList.getImages().remove(image1.getImage());
        deleteItem(0);
    }

    public void deleteItem2() throws IOException {
        ItemsList.getImages().remove(image2.getImage());
        deleteItem(1);
    }

    public void deleteItem3() throws IOException {
        ItemsList.getImages().remove(image3.getImage());
        deleteItem(2);
    }

    public void deleteItem4() throws IOException {
        ItemsList.getImages().remove(image4.getImage());
        deleteItem(3);
    }

    public void deleteItem5() throws IOException {
        ItemsList.getImages().remove(image5.getImage());
        deleteItem(4);
    }

    public void deleteItem6() throws IOException {
        ItemsList.getImages().remove(image6.getImage());
        deleteItem(5);
    }

    public void deleteItem7() throws IOException {
        ItemsList.getImages().remove(image7.getImage());
        deleteItem(6);
    }

    public void deleteItem8() throws IOException {
        ItemsList.getImages().remove(image8.getImage());
        deleteItem(7);
    }

    public void deleteItem9() throws IOException {
        ItemsList.getImages().remove(image9.getImage());
        deleteItem(8);
    }


    public void editItem() {

    }


}
