package com.example.damonpelser.launchpad.models;

/**
 * Created by damon on 2017/10/15.
 */

public class CategoryModel {
    String cateName;
    int cateIcon;

    public CategoryModel(String cateName, int cateIcon) {
        this.cateName = cateName;
        this.cateIcon = cateIcon;
    }

    public String getCateName() {
        return cateName;
    }

    public int getCateIcon() {
        return cateIcon;
    }

    public void setCateIcon(int cateIcon) {
        this.cateIcon = cateIcon;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
