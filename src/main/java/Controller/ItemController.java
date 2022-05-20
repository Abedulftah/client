package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MyListener;

import java.util.Objects;

public class ItemController {

    @FXML
    private AnchorPane anItem;

    @FXML
    private ImageView imageLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Catalog catalog;

    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(catalog);
    }

    public ItemController() {
    }

    public void setData(Catalog catalog, MyListener myListener) {
        if(catalog.getPrivilege() == 0) {
            this.catalog = catalog;
            this.myListener = myListener;
            nameLabel.setText(catalog.getName());
            priceLabel.setText(App.CURRENCY + catalog.getPrice());
            Image image = new Image(catalog.getImgUrl());
            imageLabel.setImage(image);
            anItem.setStyle("-fx-background-color: #" + catalog.getColor() + ";\n" +
                    "    -fx-background-radius: 30;" +
                    "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 ,10.0);");
        }
    }
}