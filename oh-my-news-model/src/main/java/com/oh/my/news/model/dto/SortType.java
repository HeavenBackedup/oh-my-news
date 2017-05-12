package com.oh.my.news.model.dto;

/**
 * Created by shj on 2017/5/10.
 */
public enum SortType {

    DATE(0),THUMUP(1),DONATE(2);

    int value;

    SortType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
