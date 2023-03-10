package eu.yebo.korabbiSpring2.domain;

import java.util.Date;

public class Story {
    private String title;
    private String content;
    private Date posted;
    private String author;

    public Story(String title, String content, Date posted, String author) {
        this.title = title;
        this.content = content;
        this.posted = posted;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                '}';
    }
}
