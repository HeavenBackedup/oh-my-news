package com.oh.my.news.model.vo.detail;

/**
 * Created by shj on 2017/5/13.
 */
public enum AndroidSubmitType {
    COMMENT(1,"comment"),SCORE(2,"score"),REPORT(3,"report"),DONATION(4,"reward"),THUMBUP(5,"like"),COLLECT(6,"collect");

    private int value;
    private String name;

    AndroidSubmitType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    public static int getValue(String name){
        for(AndroidSubmitType a:AndroidSubmitType.values()){
            if(a.getName().equals(name))
                return a.getValue();
        }
        return -1;
    }

}
