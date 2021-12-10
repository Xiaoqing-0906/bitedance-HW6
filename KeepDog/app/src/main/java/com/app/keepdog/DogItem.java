package com.app.keepdog;

import java.io.Serializable;

public class DogItem implements Serializable {
    public int icon;
    public String name;
    public String content;

    public DogItem(int icon, String name, String content) {
        this.icon = icon;
        this.name = name;
        this.content = content;
    }
}
