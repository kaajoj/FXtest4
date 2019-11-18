package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Calculations.prepareViewData;

public class Controller {

    public int varco;
    public int consco;



    @FXML
    public TextField countvar;
    public TextField countcons;


    public void getUserData(){
        varco = Integer.parseInt(countvar.getText());
        consco = Integer.parseInt(countcons.getText());
        if(varco<0) varco = 0;
        if(consco<0) consco = 0;
        System.out.println(varco + " " + consco);
        prepareViewData(varco, consco);
    }


    public void changeView(ActionEvent event) throws IOException {
        getUserData();

        Parent viewParent = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        Scene viewScene = new Scene(viewParent, 800, 600);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);

        window.setTitle("Karol Nowak 2");
        window.show();
    }


}
