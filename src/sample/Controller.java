package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static sample.Main.test;


public class Controller {

    @FXML
    public TextArea testTextArea;

    @FXML
    public TextField x;
    @FXML
    public TextField y;

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
        test();
    }



}
