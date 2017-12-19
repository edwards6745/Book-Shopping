/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.business;

public class Books {
    private String bookImg;
    private String title;
    private double price;
    private int quantity;
    private int bookId;
    
    public Books(int bookId, String bookImg, String title, double price) {
       this.bookImg = bookImg;
       this.title = title;
       this.price = price;
       this.bookId = bookId;
    }
    public String getBookImg() {
        return bookImg;
    }
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotal() {
        return price * quantity;
    }
    public int getKey() {
        return bookId;
    }
}
