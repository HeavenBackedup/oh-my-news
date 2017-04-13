package com.oh.my.news.model.po;

/**
 * Created by shj on 2017/4/13.
 */
public class File {
    private int id;
    private String key;
    private String url;
    private int isDelete;
    public File(int id, String key, String url) {
        this.id = id;
        this.key = key;
        this.url = url;
    }

    public File() {
    }

    public File(int id, String key, String url, int isDelete) {
        this.id = id;
        this.key = key;
        this.url = url;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        if (isDelete != file.isDelete) return false;
        if (key != null ? !key.equals(file.key) : file.key != null) return false;
        return url != null ? url.equals(file.url) : file.url == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + isDelete;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
