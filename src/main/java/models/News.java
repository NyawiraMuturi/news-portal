package models;

import org.sql2o.Connection;

import java.util.Objects;

public class News {
    private String newstitle;
    private String content;
    private int id;
    private int iddept;

    public News(String newstitle,String content, int iddept) {
        this.newstitle=newstitle;
        this.content = content;
        this.iddept = iddept;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contents) {
        this.content = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeptId() {
        return iddept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News) )return false;
        News news = (News) o;
        return id == news.id &&
                iddept == news.iddept &&
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, id, iddept);
    }

}