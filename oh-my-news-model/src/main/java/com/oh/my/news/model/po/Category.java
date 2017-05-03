package com.oh.my.news.model.po;

/**
 * Created by shj on 2017/5/1.
 */
public class Category {
    private int id;
    private int parentId;
    private String name;
    private int isDelete;

    public Category(int id, int parentId, String name, int isDelete) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.isDelete = isDelete;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (parentId != category.parentId) return false;
        if (isDelete != category.isDelete) return false;
        return name != null ? name.equals(category.name) : category.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + parentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + isDelete;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
