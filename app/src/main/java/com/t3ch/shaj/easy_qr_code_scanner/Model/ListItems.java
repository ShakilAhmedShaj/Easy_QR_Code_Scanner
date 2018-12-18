package com.t3ch.shaj.easy_qr_code_scanner.Model;

public class ListItems {

    int id;
    String code;
    String type;

    public ListItems(int id, String code, String type) {
        this.id = id;
        this.code = code;
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public String getCode() {
        return code;
    }


    public String getType() {
        return type;
    }


}
