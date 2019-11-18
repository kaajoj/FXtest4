package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

import java.io.IOException;

import static sample.Calculations.prepareViewData;
import static sample.Calculations.test2;

public class Controller {

    public int varco;
    public int consco;

    @FXML
    public TextArea testTextArea;

    @FXML
    public TextField zx1;
    public TextField zx2;
    public TextField ox1;
    public TextField ox2;
    public TextField ox11;
    public TextField ox22;
    public TextField oc1;
    public TextField oc2;

    @FXML
    public TextField countvar;
    public TextField countcons;

//    @FXML
//    public HBox hbox1;
//    private TableView tab;
//    private TableColumn tabcol;

//    @FXML
//    private void testButtonAction(ActionEvent event) {
//            String text = testTextArea.getText();
//            System.out.println(text);
//        testTextArea.setText("Test\n");
//        test();

//        try {
//            double rzx1 = Double.parseDouble(zx1.getText());
//            double rzx2 = Double.parseDouble(zx2.getText());
//            double rox1 = Double.parseDouble(ox1.getText());
//            double rox2 = Double.parseDouble(ox2.getText());
//            double rox11 = Double.parseDouble(ox11.getText());
//            double rox22 = Double.parseDouble(ox22.getText());
//            double roc1 = Double.parseDouble(oc1.getText());
//            double roc2 = Double.parseDouble(oc2.getText());
//            String res = test2(rzx1, rzx2, rox1, rox2, rox11, rox22, roc1, roc2);
//            testTextArea.setText(res);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }

    public void getUserData(){
        varco = Integer.parseInt(countvar.getText());
        consco = Integer.parseInt(countcons.getText());
        if(varco<0) varco = 0;
        if(consco<0) consco = 0;
        System.out.println(varco + " " + consco);
//        createView(varco,consco);
    }


//    public void createView(int varco, int consco){
//    prepareViewData(varco, consco);

//    }

    public void changeView(ActionEvent event) throws IOException {
        getUserData();

        Parent viewParent = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        Scene viewScene = new Scene(viewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }




}
