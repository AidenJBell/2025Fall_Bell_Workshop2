package org.example;

//Here is an outline of what should go in your book class
//There should NOT be any code that deals with menus
//There should NOT be any code that takes in user input
//All this class cares about is book data
//and what to do when the book is checked in or out, that's it
public class Book {
    //properties
    private int id = 0;
    private String isbn = "";
    private String title = "";
    private boolean isCheckOut = false;
    private String checkedOutTo = "";
    //constructor

    public Book(int id, String isbn, String title, boolean isCheckOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckOut = isCheckOut;
        this.checkedOutTo = checkedOutTo;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //check in and check out methods
    public void checkIn(){
        this.isCheckOut = false;
        this.checkedOutTo = "";
    }

    public void checkOut(String name){
        this.isCheckOut = true;
        this.checkedOutTo = name;
    }
}
