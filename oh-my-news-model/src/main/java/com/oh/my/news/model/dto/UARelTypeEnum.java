package com.oh.my.news.model.dto;

/**
 * Created by shj on 2017/5/9.
 */
public enum UARelTypeEnum {

    COLLECT(6),MARK(2),REPORT(3),THUMBUP(5);
    private int type;

    UARelTypeEnum(int type) {
        this.type = type;
    }




    public int getType(){
        return type;
    }
}
