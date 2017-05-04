package com.example.sangameswaran.nammachennai;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class BookModelClass {

    String bookname,bookisbn,authorname,availablity,publishers,bookedition,ownername,ownercontactnum;
    BookModelClass(String bookname,String bookisbn,String authorname,String availablity,String publishers,String bookedition,String ownername,String ownercontactnum)
    {
        //parameterized constructor to initialize the books

        this.bookname=bookname;
        this.bookisbn=bookisbn;
        this.authorname=authorname;
        this.availablity=availablity;
        this.publishers=publishers;
        this.bookedition=bookedition;
        this.ownername=ownername;
        this.ownercontactnum=ownercontactnum;
    }
    BookModelClass()
    {
        //default constructor;

    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        this.availablity = availablity;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getBookedition() {
        return bookedition;
    }

    public void setBookedition(String bookedition) {
        this.bookedition = bookedition;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwnercontactnum() {
        return ownercontactnum;
    }

    public void setOwnercontactnum(String ownercontactnum) {
        this.ownercontactnum = ownercontactnum;
    }
}
