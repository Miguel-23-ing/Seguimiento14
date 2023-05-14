package com.example.bancoalfa.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataList {

    private ObservableList<Data> dataList = FXCollections.observableArrayList();

    private DataList(){}

    private static DataList instance = null;

    public static DataList getInstance(){
        if(instance == null){
            instance = new DataList();
        }
        return instance;
    }

    public ObservableList<Data> getDataList() {
        return dataList;
    }

    public void setDataList(ObservableList<Data> dataList) {
        this.dataList = dataList;
    }

    public static void setInstance(DataList instance) {
        DataList.instance = instance;
    }
}
