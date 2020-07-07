import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MyController implements Initializable {
    @FXML
    private Button dateButton;

    @FXML
    private TextField dateTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showDateTime(ActionEvent actionEvent) {
        System.out.println("Button clicked");
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dateTime = dateFormat.format(now);
        dateTextField.setText(dateTime);
    }
}
