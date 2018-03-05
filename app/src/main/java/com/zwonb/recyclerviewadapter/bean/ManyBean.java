package com.zwonb.recyclerviewadapter.bean;

import com.zwonb.rvadapter.ManyItemType;

/**
 * 第一种类型的bean
 * Created by zwonb on 2018/1/15.
 */

public class ManyBean implements ManyItemType {

    private String str;
    private int img;
    private int type;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemViewType() {
        return getType();
    }
}
