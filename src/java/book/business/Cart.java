/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.business;
import java.util.*;
/**
 *
 * @author Austin
 */
public class Cart {
    
    private static final  ArrayList<Books> cart = new ArrayList<>();
    public Cart() {}
    public boolean contains(int bookId) {
        return cart.stream().anyMatch((book) -> (book.getBookId() == bookId));
    }
    public void addToCart(int bookId) {
        Books book = BookList.getAllBooks().get(bookId);
        
        book.setQuantity(1);
        cart.add(book);
    }
    public void addOneQuantity(int bookId) {
        for (Books book : cart) {
            if(book.getBookId() == bookId) {
                book.setQuantity(book.getQuantity() + 1);
                break;
            }
        }
    }
    public void removeFromCart(int bookId) {
        for(Books book : cart) {
            if(book.getBookId() == bookId) {
                cart.remove(book);
                break;
            }
        }
    }
    public void updateCart(int quantity, int bookId) {
        if(quantity == 0) {
            removeFromCart(bookId);
        }
        else {
            for(Books book: cart) {
                if(book.getBookId() == bookId) {
                    book.setQuantity(quantity);
                    break;
                }
            }
        }
    }
    public void clearCart() {
        cart.clear();
    }
    public int cartSize() {
        return cart.size();
    }
    public static List<Books> getCart() {
        return cart;
    }
    public double totalPrice() {
        double total = 0.00;
        for(Books book : cart) {
            total += (book.getPrice() * book.getQuantity());
        }
        return total;
    }
}
