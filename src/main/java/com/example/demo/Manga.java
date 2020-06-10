package com.example.demo;

public class Manga {
    private String bookID;
    private String title;
    private String date;
    private String thumnailPath;
    private String book_rate;
    private String author;

    public Manga() {
    }

    public Manga(String bookID, String title, String date, String thumnailPath, String book_rate, String author) {
        this.bookID = bookID;
        this.title = title;
        this.date = date;
        this.thumnailPath = thumnailPath;
        this.book_rate = book_rate;
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumnailPath() {
        return thumnailPath;
    }

    public void setThumnailPath(String thumnailPath) {
        this.thumnailPath = thumnailPath;
    }

    public String getBook_rate() {
        return book_rate;
    }

    public void setBook_rate(String book_rate) {
        this.book_rate = book_rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
