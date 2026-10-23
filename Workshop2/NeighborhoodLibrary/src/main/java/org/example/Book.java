package org.example;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isChecketOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isChecketOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isChecketOut = isChecketOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecketOut() {
        return isChecketOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public void checOut (String name){

    }
}
