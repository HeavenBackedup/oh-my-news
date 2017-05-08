package com.oh.my.news.model.dto;

/**
 * Created by shj on 2017/4/13.
 */
public class Image {
    private int id;
    private String url;

    public Image(int id, String url) {
        this.id = id;
        this.url = url;
    }
    public Image() {
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (id != image.id) return false;
        return url != null ? url.equals(image.url) : image.url == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
