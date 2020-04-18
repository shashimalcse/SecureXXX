package com.example.securex.applock;

import android.graphics.drawable.Drawable;

public class Application {

    private String Name;
    private Drawable Icon;

    public Application(String name, Drawable icon) {
        Name = name;
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public Drawable getIcon() {
        return Icon;
    }
}
