package mainpage;

import java.util.Date;
import java.util.List;

/**
 * Created by Dzhaoooo on 17/4/15.
 */
public class News {
    private  int index;

    private String title;   //标题
    private String author;  //作者
    private String date;      //发布日期
    private List<String> picUrls; //新闻对应图片集
    private String content;    // 正文


    public News(int index, String title, String author, String date, List<String> picUrls, String content) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.date = date;
        this.picUrls = picUrls;
        this.content = content;
    }


    public News() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", picUrls=" + picUrls +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (index != news.index) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (author != null ? !author.equals(news.author) : news.author != null) return false;
        if (date != null ? !date.equals(news.date) : news.date != null) return false;
        if (picUrls != null ? !picUrls.equals(news.picUrls) : news.picUrls != null) return false;
        return content != null ? content.equals(news.content) : news.content == null;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (picUrls != null ? picUrls.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}

