package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Calculations.test2;

public class Controller {

    public int varcount;
    public int conscount;

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

    @FXML
    private void testButtonAction(ActionEvent event) {
        // Button was clicked, do something…
//            String text = testTextArea.getText();
//            System.out.println(text);
//        testTextArea.setText("Test\n");
//        System.out.println("test123");
//            int a = Integer.parseInt(x.getText());
//            int b = Integer.parseInt(y.getText());
//            int sum = a+b;
//            System.out.println(sum);
//        test();
        try {
            double rzx1 = Double.parseDouble(zx1.getText());
            double rzx2 = Double.parseDouble(zx2.getText());
            double rox1 = Double.parseDouble(ox1.getText());
            double rox2 = Double.parseDouble(ox2.getText());
            double rox11 = Double.parseDouble(ox11.getText());
            double rox22 = Double.parseDouble(ox22.getText());
            double roc1 = Double.parseDouble(oc1.getText());
            double roc2 = Double.parseDouble(oc2.getText());
            String res = test2(rzx1, rzx2, rox1, rox2, rox11, rox22, roc1, roc2);
            testTextArea.setText(res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void getUserData(){
        varcount = Integer.parseInt(countvar.getText());
        conscount = Integer.parseInt(countcons.getText());
        System.out.println(varcount + " " + conscount);
    }

    public void changeView(ActionEvent event) throws IOException {
        getUserData();
        Parent viewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene viewScene = new Scene(viewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }

}
