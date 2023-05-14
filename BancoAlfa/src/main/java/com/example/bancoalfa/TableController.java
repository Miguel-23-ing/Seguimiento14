package com.example.bancoalfa;

import com.example.bancoalfa.model.Data;
import com.example.bancoalfa.model.DataList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private Label BalanceLB;

    @FXML
    private Button addBTN;

    @FXML
    private TableColumn<Data, Double> amountTc;

    @FXML
    private TableView<Data> bank;

    @FXML
    private Button cashFlowBtn;

    @FXML
    private TableColumn<Data, LocalDate> dateTc;

    @FXML
    private TableColumn<Data, String> descriptionTc;

    @FXML
    private Button expenseBtn;

    @FXML
    private Button incomeBtn;

    @FXML
    private TableColumn<Data, String> typeTc;

    @FXML
    void addBtnAction(ActionEvent event) {

    }

    @FXML
    void cashFlowBtnAction(ActionEvent event) {
        bank.setItems(dataList);
    }

    @FXML
    void expenseBtnAction(ActionEvent event) {
        ObservableList<Data> gastosList = FXCollections.observableArrayList();
        for (Data data : dataList) {
            if ("Gasto".equals(data.getType())) {
                gastosList.add(data);
            }
        }
        gastosList.sort(Comparator.comparing(Data::getDate).reversed());
        bank.setItems(gastosList);
    }

    @FXML
    void incomeBtnAction(ActionEvent event) {
        ObservableList<Data> incomeList = FXCollections.observableArrayList();
        for (Data data : dataList) {
            if ("Ingreso".equals(data.getType())) {
                incomeList.add(data);
            }
        }
        incomeList.sort(Comparator.comparing(Data::getDate).reversed());
        bank.setItems(incomeList);
    }


    private ObservableList<Data> dataList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountTc.setCellValueFactory(new PropertyValueFactory<>("amount"));
        descriptionTc.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeTc.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateTc.setCellValueFactory(new PropertyValueFactory<>("date"));

        dataList = DataList.getInstance().getDataList();
        dataList.sort(Comparator.comparing(Data::getDate).reversed());

        bank.setItems(dataList);

        addBTN.setOnAction(actionEvent -> {
            HelloApplication.openWindow("register-delete.fxml");
            Stage stage = (Stage) this.addBTN.getScene().getWindow();
            stage.close();
        });
        double totalIncome = 0.0;
        double totalExpense = 0.0;
        for (Data data : DataList.getInstance().getDataList()) {
            if ("Ingreso".equals(data.getType())) {
                totalIncome += data.getAmount();
            } else if ("Gasto".equals(data.getType())) {
                totalExpense += data.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;
        BalanceLB.setText(String.valueOf(balance));

    }
}