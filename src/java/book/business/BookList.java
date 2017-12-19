/* Austin Edwards
cs4010 hw3
10/27/2016 */

package book.business;
import java.io.Serializable;
import java.util.HashMap;

public class BookList implements Serializable {
   private static HashMap<Integer, Books> books;
   public static HashMap<Integer, Books> getAllBooks() {
       if (books == null) {
           populateBooks();
       }
       return books;
   }
   private static void populateBooks() {
       books = new HashMap<>();
       
       books.put(0, new Books(0, "http://onlinebooksforchildren.com/sites/default/files/styles/300/public/TheCatInTheHat.jpg?itok=26q85v-2", "The Cat in the Hat", 8.79));
       books.put(1, new Books(1, "https://upload.wikimedia.org/wikipedia/en/1/13/The_Lorax.jpg", "The Lorax", 12.45));
       books.put(2, new Books(2, "https://images-na.ssl-images-amazon.com/images/I/515MM70DN5L._SY344_BO1,204,203,200_.jpg", "If I Ran the Circus", 6.75));
       books.put(3, new Books(3, "https://upload.wikimedia.org/wikipedia/en/8/87/How_the_Grinch_Stole_Christmas_cover.png", "How the Grinch Stole Christmas", 9.60));
   }
}
