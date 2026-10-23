package org.example;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
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

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public void checkOut (String name){
        if(!isCheckedOut){
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.printf("The Book with Title %s has been checked out to %s\n.", title , name.toUpperCase());
        }else{
            System.out.println("This book has already checked out.");
        }
    }
    public void checkIn(){
        if(isCheckedOut){
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.printf("Thank you for returning the book with Title %s.\n", title);
        } else{
            System.out.printf("The book %s is already available.\n",title);
        }

    }

}
