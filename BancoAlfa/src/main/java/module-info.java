module com.example.bancoalfa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bancoalfa to javafx.fxml;
    exports com.example.bancoalfa;

    opens com.example.bancoalfa.model to javafx.base;
    exports com.example.bancoalfa.model;
}