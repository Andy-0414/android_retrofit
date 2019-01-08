package com.example.sunrin_08.myapplication;

import org.json.JSONObject;

public class Item {
    String title;
    String path;
    String type;

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}
