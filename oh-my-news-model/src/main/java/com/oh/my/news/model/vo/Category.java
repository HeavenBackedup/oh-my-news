package com.oh.my.news.model.vo;

/**
 * Created by shj on 2017/4/15.
 */
public class Category {
    private int id;
    private Category parent;
    private String catName;

    public Category(int id, Category category, String catName) {
        this.id = id;
        this.parent = category;
        this.catName = catName;
    }

    public Category() {
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category=" + parent +
                ", catName='" + catName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category1 = (Category) o;

        if (id != category1.id) return false;
        if (parent != null ? !parent.equals(category1.parent) : category1.parent != null) return false;
        return catName != null ? catName.equals(category1.catName) : category1.catName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (parent!= null ? parent.hashCode() : 0);
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
