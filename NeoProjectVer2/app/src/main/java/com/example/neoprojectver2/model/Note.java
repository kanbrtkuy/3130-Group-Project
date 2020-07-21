package com.example.neoprojectver2.model;

public class Note {
    private String title;
    private String content;
    private String comment;

    public Note() {

    }

    public Note(String title, String content, String comment) {
        this.title = title;
        this.content = content;
        this.comment = comment;
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

    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return this.comment;
    }
}
