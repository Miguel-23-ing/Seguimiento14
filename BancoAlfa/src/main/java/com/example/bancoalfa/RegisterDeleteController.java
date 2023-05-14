package com.example.bancoalfa;

import com.example.bancoalfa.model.Data;
import com.example.bancoalfa.model.DataList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegisterDeleteController implements Initializable {
    @FXML
    private TextField amountTf;

    @FXML
    private DatePicker datePick;

    @FXML
    private TextField descriptionTf;

    @FXML
    private Button okeyBtn;

    @FXML
    private ComboBox<String> optionTypeCB;

    @FXML
    void okeyBtnAction(ActionEvent event) {
        try {
            double amount = Double.parseDouble(amountTf.getText());
            String description = descriptionTf.getText();
            String type = optionTypeCB.getValue();
            LocalDate date = datePick.getValue();
            Data data = new Data(amount, description, type, date);
            DataList.getInstance().getDataList().add(data);
            HelloApplication.openWindow("hello-view.fxml");
            Stage stage = (Stage) this.okeyBtn.getScene().getWindow();
            stage.close();
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Lo que ha ingresado NO es un valor válido");
            alert.showAndWait();
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Ingreso", "Gasto");
        optionTypeCB.setItems(list);
        optionTypeCB.setPromptText("Elija el tipo de movimiento");
        optionTypeCB.getSelectionModel().selectedItemProperty().addListener((value, old, nu)->{
        });

    }
}
