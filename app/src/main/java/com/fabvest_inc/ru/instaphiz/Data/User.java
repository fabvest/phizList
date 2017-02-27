package com.fabvest_inc.ru.instaphiz.Data;

/**
 * Created by fab on 24.02.2017.
 */

public class User {
    private static int id = 0;
    private String mName;
    private String lesson;
    private int mark;
    private int price;
    private boolean isKafedra;

    private int semester;

    public User() {
    }

    public User(String name, String lesson, int mark, int price, boolean isKafedra, int semester) {
        this.id++;
        this.mName = name;
        this.lesson = lesson;
        this.mark = mark;
        this.price = price;
        this.isKafedra = isKafedra;
        this.semester = semester;
    }

    public static int getmId() {
        return id;
    }

    public static void setmId(int id) {
        User.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isKafedra() {
        return isKafedra;
    }

    public void setKafedra(boolean kafedra) {
        isKafedra = kafedra;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
